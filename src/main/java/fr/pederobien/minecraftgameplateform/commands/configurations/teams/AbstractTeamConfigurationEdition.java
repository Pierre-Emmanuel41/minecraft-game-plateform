package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public class AbstractTeamConfigurationEdition<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected AbstractTeamConfigurationEdition(ILabel label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * Remove players already mentioned from the stream returned by {@link IGameConfigurationHelper#getFreePlayers()}.
	 * 
	 * @param alreadyMentionedPlayers A list that contains already mentioned players.
	 * @return A stream that contains free and not mentioned players.
	 */
	protected Stream<Player> getFreePlayers(List<String> alreadyMentionedPlayers) {
		return getGameConfigurationHelper().getFreePlayers().filter(player -> !alreadyMentionedPlayers.contains(player.getName()));
	}

	/**
	 * Remove players already mentioned from the stream returned by {@link IGameConfigurationHelper#getNotFreePlayers()}.
	 * 
	 * @param alreadyMentionedPlayers A list that contains already mentioned players.
	 * @return A stream that contains not free and not mentioned players.
	 */
	protected Stream<Player> getNotFreePlayers(List<String> alreadyMentionedPlayers) {
		return getGameConfigurationHelper().getNotFreePlayers().filter(player -> !alreadyMentionedPlayers.contains(player.getName()));
	}

	/**
	 * Remove teams already mentioned from the list returned by {@link IGameConfiguration#getTeams()}.
	 * 
	 * @param alreadyMentionedTeams A list that contains already mentioned teams.
	 * @return A stream that contains not mentioned teams.
	 */
	protected Stream<ITeam> getFreeTeams(List<String> alreadyMentionedTeams) {
		return get().getTeams().stream().filter(team -> !alreadyMentionedTeams.contains(team.getName()));
	}

	/**
	 * Get a stream that contains the name of all registered teams that does not contains the given player.
	 * 
	 * @param playerName The player's name used to filter the list of team for this configuration
	 * @return A stream that contains the name name of all teams except the team of the given player.
	 * 
	 * @throws PlayerNotFoundException If the player associated to the given name does not exist.
	 */
	protected Stream<String> getOtherTeamNames(String playerName) {
		return getGameConfigurationHelper().getOtherTeams(playerName).map(team -> team.getName());
	}

	/**
	 * Get a list of players associated to each player's name in array <code>playerNames</code>
	 * 
	 * @param playerNames The array that contains player names.
	 * @return The list of players.
	 * 
	 * @see #getPlayer(String)
	 */
	protected List<Player> getPlayers(String[] playerNames) {
		List<Player> players = new ArrayList<Player>();
		for (String playerName : playerNames)
			players.add(getPlayer(playerName));
		return players;
	}

	/**
	 * Get a list of string that correspond to the name of each player in the given list <code>players</code>
	 * 
	 * @param players The list of player used to get their name.
	 * @return The list of player's name.
	 */
	protected List<String> getPlayerNames(List<Player> players) {
		return players.stream().map(player -> player.getName()).collect(Collectors.toList());
	}

	/**
	 * Get a list of teams associated to each team name in array <code>teamNames</code>
	 * 
	 * @param teamNames The array that contains team names.
	 * @return The list of teams.
	 * 
	 * @see #getTeam(String)
	 */
	protected List<ITeam> getTeams(String[] teamNames) {
		List<ITeam> teams = new ArrayList<ITeam>();
		for (String teamName : teamNames)
			teams.add(getTeam(teamName));
		return teams;
	}

	/**
	 * Get a list of string that correspond to the name of each team in the given list <code>teams</code>
	 * 
	 * @param teams    The list of team used to get their name.
	 * @param coloured True if each team's name is coloured, false otherwise.
	 * @return The list of team's name.
	 */
	protected List<String> getTeamNames(List<ITeam> teams, boolean coloured) {
		return teams.stream().map(team -> coloured ? team.getColoredName() : team.getName()).collect(Collectors.toList());
	}

	/**
	 * Get a list of string that correspond to the name of each {@link EColor} not used by the registered teams for this
	 * configuration.
	 * 
	 * @param coloured True if each color's name is coloured, false otherwise.
	 * 
	 * @return The list of free color's name.
	 */
	protected List<String> getFreeColorNames(boolean coloured) {
		return getGameConfigurationHelper().getAvailableColors().map(color -> coloured ? color.getColoredColorName() : color.getName()).collect(Collectors.toList());
	}
}
