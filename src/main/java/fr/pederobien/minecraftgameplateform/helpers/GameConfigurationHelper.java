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

import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerAlreadyRegisteredException;
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
		ITeam team = PlateformTeam.of(name, color);
		configuration.add(team);
		alreadyUsedColors.add(color);
		return team;
	}

	@Override
	public void remove(String teamName) {
		ITeam team = checkTeamExist(teamName);
		configuration.remove(team);
		alreadyUsedColors.remove(team.getColor());
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
	public ITeam remove(String teamName, Player player) {
		return synchronizedRemove(checkTeamExist(teamName), player);
	}

	@Override
	public ITeam remove(String teamName, List<Player> players) {
		ITeam team = checkTeamExist(teamName);
		for (Player player : players)
			synchronizedRemove(team, player);
		return team;
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
	public Stream<String> getTeamNames(boolean colored) {
		return getTeamsStream().map(team -> colored ? team.getColoredName() : team.getName());
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

	private Player checkPlayerNotAlreadyRegistered(Player player) {
		for (ITeam team : configuration.getTeams())
			if (team.getPlayers().contains(player))
				throw new PlayerAlreadyRegisteredException(configuration, team, player);
		return player;
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
}
