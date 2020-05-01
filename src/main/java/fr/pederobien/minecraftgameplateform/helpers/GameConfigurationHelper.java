package fr.pederobien.minecraftgameplateform.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerNotRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.impl.element.PlateformTeam;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.utils.EColor;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.minecraftmanagers.TeamManager;

public class GameConfigurationHelper implements IGameConfigurationHelper {
	private IGameConfiguration configuration;
	private List<EColor> alreadyUsedColors;
	private List<Player> registeredPlayers;

	public GameConfigurationHelper(IGameConfiguration configuration) {
		this.configuration = configuration;
		alreadyUsedColors = new ArrayList<EColor>();
		registeredPlayers = new ArrayList<Player>();
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
			synchronizedRemove(team, player);
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
	public void teleportTeamsRandomly(World world, int bound) {
		getTeamsStream().peek(team -> TeamHelper.teleportTeamRandomly(team, world, bound));
	}

	@Override
	public ITeam add(String teamName, String playerName) {
		return synchronizedAdd(checkTeamExist(teamName), checkPlayerNotAlreadyRegistered(checkPlayerExist(playerName)));
	}

	@Override
	public ITeam add(String teamName, String[] playerNames) {
		ITeam team = checkTeamExist(teamName);
		for (String playerName : playerNames)
			synchronizedAdd(team, checkPlayerNotAlreadyRegistered(checkPlayerExist(playerName)));
		return team;
	}

	@Override
	public ITeam add(String teamName, Player player) {
		return synchronizedAdd(checkTeamExist(teamName), checkPlayerNotAlreadyRegistered(player));
	}

	@Override
	public ITeam add(String teamName, List<Player> players) {
		ITeam team = checkTeamExist(teamName);
		for (Player player : players)
			synchronizedAdd(team, checkPlayerNotAlreadyRegistered(player));
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
		return synchronizedRemove(checkPlayerRegistered(player), player);
	}

	@Override
	public List<ITeam> removePlayers(List<Player> players) {
		List<ITeam> teams = new ArrayList<ITeam>();
		for (Player player : players)
			teams.add(synchronizedRemove(checkPlayerRegistered(player), player));
		return teams;
	}

	@Override
	public void movePlayer(Player player, String teamName) {
		ITeam newTeam = checkTeamExist(teamName);
		Optional<ITeam> oldTeam = getTeam(player);
		if (oldTeam.isPresent())
			oldTeam.get().removePlayer(player);
		newTeam.addPlayer(player);
	}

	@Override
	public Stream<EColor> getAvailableColors() {
		return Arrays.asList(EColor.values()).stream().filter(color -> !alreadyUsedColors.contains(color));
	}

	@Override
	public Stream<Player> getFreePlayers() {
		return PlayerManager.getPlayers().filter(player -> !registeredPlayers.contains(player));
	}

	@Override
	public Stream<Player> getNotFreePlayers() {
		return getTeamsStream().map(team -> team.getPlayers().stream()).reduce(Stream.of(), (players, playersTeam) -> Stream.concat(players, playersTeam));
	}

	@Override
	public Stream<String> getTeamNames(boolean colored) {
		return getTeamsStream().map(team -> colored ? team.getColoredName() : team.getName());
	}

	@Override
	public Stream<EColor> getFreeColors() {
		return getTeamsStream().map(team -> team.getColor()).filter(color -> !alreadyUsedColors.contains(color));
	}

	@Override
	public ITeam renameTeam(String oldName, String newName) {
		ITeam teamToRename = checkTeamExist(oldName);
		checkNameNotForbidden(newName);
		checkNameIsNotUsed(newName);
		teamToRename.setName(newName);
		return teamToRename;
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

	private ITeam synchronizedAdd(ITeam team, Player player) {
		team.addPlayer(player);
		registeredPlayers.add(player);
		return team;
	}

	private ITeam synchronizedRemove(ITeam team, Player player) {
		team.removePlayer(player);
		registeredPlayers.remove(player);
		return team;
	}

	private ITeam synchronizedAdd(String teamName, EColor color) {
		ITeam team = PlateformTeam.of(teamName, color);
		configuration.add(team);
		alreadyUsedColors.add(color);
		return team;
	}

	private ITeam synchronizedRemove(ITeam team) {
		configuration.remove(team);
		alreadyUsedColors.remove(team.getColor());
		// Remove each player from the team and from the registered players list
		for (Player player : team.getPlayers())
			synchronizedRemove(team, player);
		return team;
	}
}
