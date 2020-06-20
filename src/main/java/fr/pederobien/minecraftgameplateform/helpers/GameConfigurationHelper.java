package fr.pederobien.minecraftgameplateform.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerNotRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamsAreTheSameException;
import fr.pederobien.minecraftgameplateform.impl.element.PlateformTeam;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.utils.EColor;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.minecraftmanagers.TeamManager;

public class GameConfigurationHelper implements IGameConfigurationHelper {
	private IGameConfiguration configuration;

	public GameConfigurationHelper(IGameConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public ITeam create(String name, EColor color) {
		checkNameNotForbidden(name);
		checkNameIsNotUsed(name);
		checkColorIsNotUsed(color);
		return synchronizedAdd(name, color);
	}

	@Override
	public ITeam removeTeam(String teamName) {
		return synchronizedRemove(checkTeamExist(teamName));
	}

	@Override
	public List<ITeam> removeTeams(String[] teamNames) {
		List<ITeam> teams = new ArrayList<ITeam>();
		for (String teamName : teamNames)
			teams.add(removeTeam(teamName));
		return teams;
	}

	@Override
	public List<ITeam> clearTeams() {
		List<ITeam> teams = new ArrayList<ITeam>();
		configuration.getTeams().forEach(team -> teams.add(team));
		teams.forEach(team -> synchronizedRemove(team));
		return teams;
	}

	@Override
	public List<Player> clearPlayers() {
		List<Player> players = new ArrayList<Player>();
		configuration.getTeams().forEach(team -> team.getPlayers().forEach(player -> {
			players.add(player);
			removePlayerFromTeam(team, player);
		}));
		return players;
	}

	@Override
	public Optional<ITeam> getTeam(Player player) {
		return filterTeam(team -> team.getPlayers().contains(player));
	}

	@Override
	public Optional<ITeam> getTeam(EColor color) {
		return filterTeam(team -> team.getColor().equals(color));
	}

	@Override
	public Optional<ITeam> getTeam(String teamName) {
		return filterTeam(team -> team.getName().equals(teamName));
	}

	@Override
	public List<Player> getColleagues(Player player) {
		Optional<ITeam> optTeam = getTeam(player);
		if (!optTeam.isPresent())
			return new ArrayList<Player>();
		return optTeam.get().getPlayers().stream().filter(n -> !n.equals(player)).collect(Collectors.toList());
	}

	@Override
	public Optional<Player> getRandomColleague(Player player) {
		Optional<ITeam> optTeam = getTeam(player);
		if (!optTeam.isPresent())
			Optional.empty();
		return TeamManager.getRandom(optTeam.get().getPlayers());
	}

	@Override
	public Optional<Player> getRandomColleague(Player player, Predicate<Player> predicate) {
		Optional<ITeam> optTeam = getTeam(player);
		if (!optTeam.isPresent())
			return Optional.empty();
		return TeamHelper.getRandom(optTeam.get().getPlayers().stream(), predicate);
	}

	@Override
	public void teleportTeamsRandomly(World world, Block center, int bound) {
		getTeamsStream().forEach(team -> TeamHelper.teleportTeamRandomly(team, world, center, bound));
	}

	@Override
	public ITeam add(String teamName, String playerName) {
		return addPlayerToTeam(checkTeamExist(teamName), checkPlayerNotAlreadyRegistered(checkPlayerExist(playerName)));
	}

	@Override
	public ITeam add(String teamName, String[] playerNames) {
		ITeam team = checkTeamExist(teamName);
		for (String playerName : playerNames)
			addPlayerToTeam(team, checkPlayerNotAlreadyRegistered(checkPlayerExist(playerName)));
		return team;
	}

	@Override
	public ITeam add(String teamName, Player player) {
		return addPlayerToTeam(checkTeamExist(teamName), checkPlayerNotAlreadyRegistered(player));
	}

	@Override
	public ITeam add(String teamName, List<Player> players) {
		ITeam team = checkTeamExist(teamName);
		for (Player player : players)
			addPlayerToTeam(team, checkPlayerNotAlreadyRegistered(player));
		return team;
	}

	@Override
	public ITeam removePlayer(String playerName) {
		return removePlayer(checkPlayerExist(playerName));
	}

	@Override
	public List<ITeam> removePlayers(String[] players) {
		List<ITeam> teams = new ArrayList<ITeam>();
		for (String player : players)
			teams.add(removePlayer(player));
		return teams;
	}

	@Override
	public ITeam removePlayer(Player player) {
		return removePlayerFromTeam(checkPlayerRegistered(player), player);
	}

	@Override
	public List<ITeam> removePlayers(List<Player> players) {
		List<ITeam> teams = new ArrayList<ITeam>();
		for (Player player : players)
			teams.add(removePlayerFromTeam(checkPlayerRegistered(player), player));
		return teams;
	}

	@Override
	public ITeam[] movePlayer(String playerName, String teamName) {
		Player player = checkPlayerExist(playerName);
		ITeam initialTeam = checkPlayerRegistered(player);
		ITeam targetTeam = checkTeamExist(teamName);
		return movePlayer(initialTeam, targetTeam, player);
	}

	@Override
	public void movePlayer(Player player, ITeam targetTeam) {
		ITeam initialTeam = checkPlayerRegistered(player);
		movePlayer(initialTeam, targetTeam, player);
	}

	@Override
	public Stream<EColor> getAvailableColors() {
		List<EColor> alreadyUsedColors = getAlreadyUsedColors();
		return Arrays.asList(EColor.values()).stream().filter(color -> !alreadyUsedColors.contains(color));
	}

	@Override
	public Stream<Player> getFreePlayers() {
		List<Player> registeredPlayers = getRegisteredPlayers();
		return PlayerManager.getPlayers().filter(player -> !registeredPlayers.contains(player));
	}

	@Override
	public Stream<Player> getNotFreePlayers() {
		return getRegisteredPlayers().stream();
	}

	@Override
	public Stream<String> getTeamNames(boolean colored) {
		return getTeamsStream().map(team -> colored ? team.getColoredName() : team.getName());
	}

	@Override
	public Stream<ITeam> getOtherTeams(String playerName) {
		Player player = checkPlayerExist(playerName);
		return getTeamsStream().filter(team -> !team.getPlayers().contains(player));
	}

	@Override
	public ITeam renameTeam(String oldName, String newName) {
		ITeam teamToRename = checkTeamExist(oldName);
		checkNameNotForbidden(newName);
		checkNameIsNotUsed(newName);
		teamToRename.setName(newName);
		return teamToRename;
	}

	@Override
	public ITeam modifyTeamColor(String teamName, String newColor) {
		ITeam team = checkTeamExist(teamName);
		EColor color = checkColorExist(newColor);
		checkColorIsNotUsed(color);
		team.setColor(color);
		return team;
	}

	private Stream<ITeam> getTeamsStream() {
		return configuration.getTeams().stream();
	}

	private Optional<ITeam> filterTeam(Predicate<ITeam> predicate) {
		return getTeamsStream().filter(predicate).findFirst();
	}

	private ITeam checkTeamExist(String teamName) {
		Optional<ITeam> optTeam = getTeam(teamName);
		if (!optTeam.isPresent())
			throw new TeamNotFoundException(configuration, teamName);
		return optTeam.get();
	}

	private void checkNameIsNotUsed(String name) {
		Optional<ITeam> optTeam = getTeam(name);
		if (optTeam.isPresent())
			throw new TeamWithSameNameAlreadyExistsException(configuration, optTeam.get());
	}

	private void checkNameNotForbidden(String name) {
		if (name.equals(ALL))
			throw new TeamNameForbiddenException(configuration, ALL);
	}

	private EColor checkColorExist(String colorName) {
		EColor color = EColor.getByColorName(colorName);
		if (color == null)
			throw new ColorNotFoundException(colorName);
		return color;
	}

	private void checkColorIsNotUsed(EColor color) {
		Optional<ITeam> optTeam = getTeam(color);
		if (optTeam.isPresent())
			throw new TeamWithSameColorAlreadyExistsException(configuration, optTeam.get());
	}

	private Player checkPlayerExist(String playerName) {
		Player player = PlayerManager.getPlayer(playerName);
		if (player == null)
			throw new PlayerNotFoundException(playerName);
		return player;
	}

	private Player checkPlayerNotAlreadyRegistered(Player player) {
		for (ITeam team : configuration.getTeams())
			if (team.getPlayers().contains(player))
				throw new PlayerAlreadyRegisteredException(configuration, team, player);
		return player;
	}

	private ITeam checkPlayerRegistered(Player player) {
		Optional<ITeam> optTeam = getTeam(player);
		if (!optTeam.isPresent())
			throw new PlayerNotRegisteredException(configuration, player);
		return optTeam.get();
	}

	private void checkTeamAreDifferent(ITeam initialTeam, ITeam targetTeam) {
		if (initialTeam.equals(targetTeam))
			throw new TeamsAreTheSameException(configuration, initialTeam, targetTeam);
	}

	private ITeam addPlayerToTeam(ITeam team, Player player) {
		team.addPlayer(player);
		return team;
	}

	private ITeam removePlayerFromTeam(ITeam team, Player player) {
		team.removePlayer(player);
		return team;
	}

	private ITeam synchronizedAdd(String teamName, EColor color) {
		ITeam team = PlateformTeam.of(teamName, color);
		configuration.add(team);
		return team;
	}

	private ITeam synchronizedRemove(ITeam team) {
		configuration.remove(team);
		// Remove each player from the team and from the registered players list
		for (Player player : team.getPlayers())
			removePlayerFromTeam(team, player);
		return team;
	}

	private ITeam[] movePlayer(ITeam initialTeam, ITeam targetTeam, Player player) {
		checkTeamAreDifferent(initialTeam, targetTeam);
		ITeam[] teams = new ITeam[2];
		initialTeam.removePlayer(player);
		targetTeam.addPlayer(player);
		teams[0] = initialTeam;
		teams[1] = targetTeam;
		return teams;
	}

	private List<EColor> getAlreadyUsedColors() {
		List<EColor> alreadyUsedColors = new ArrayList<>();
		for (ITeam team : configuration.getTeams())
			alreadyUsedColors.add(team.getColor());
		return alreadyUsedColors;
	}

	private List<Player> getRegisteredPlayers() {
		List<Player> registeredPlayers = new ArrayList<Player>();
		for (ITeam team : configuration.getTeams())
			registeredPlayers.addAll(team.getPlayers());
		return registeredPlayers;
	}
}
