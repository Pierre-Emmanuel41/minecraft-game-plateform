package fr.pederobien.minecraftgameplateform.interfaces.helpers;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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
import fr.pederobien.minecraftgameplateform.helpers.TeamHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftmanagers.EColor;

public interface IGameConfigurationHelper {
	/**
	 * The forbidden name for a team.
	 */
	public static final String ALL = "all";

	/**
	 * Create a team and add it to this configuration if and only if the name and the color are not already used.
	 * 
	 * @param name  The team's name.
	 * @param color The team's color.
	 * 
	 * @return The created team.
	 * 
	 * @throws TeamWithSameNameAlreadyExistsException  If the name is already used by another team.
	 * @throws TeamNameForbiddenException              If the given name equals "all".
	 * @throws TeamWithSameColorAlreadyExistsException If the color is already used by another team.
	 */
	ITeam create(String name, EColor color);

	/**
	 * Remove the team associated to the given name if it exist.
	 * 
	 * @param teamName The team's name.
	 * 
	 * @return The removed team.
	 * 
	 * @throws TeamNotFoundException If the team associated to the given name does not exists for this configuration.
	 */
	ITeam removeTeam(String teamName);

	/**
	 * Remove each team associated to the name in the <code>teamNames</code> if it exist.
	 * 
	 * @param teamNames The name of each team to remove.
	 * 
	 * @return The list of removed teams.
	 * 
	 * @throws TeamNotFoundException If a team associated to a name does not exists for this configuration.
	 */
	List<ITeam> removeTeams(String[] teamNames);

	/**
	 * Remove all registered teams for this configuration.
	 * 
	 * @return The list of removed teams.
	 */
	List<ITeam> clearTeams();

	/**
	 * Remove all registered players for this configuration.
	 * 
	 * @return The list of removed players.
	 */
	List<Player> clearPlayers();

	/**
	 * Get the team in which the given player is registered. To do this, this method search the given player into each team of the
	 * configuration.
	 * 
	 * @param player The player used to get the team.
	 * 
	 * @return An optional that contains the team if, the player is registered into a team, an empty optional otherwise.
	 */
	Optional<ITeam> getTeam(Player player);

	/**
	 * Get the team whose color is the given color. To do this, this method search the color of each team registered into this
	 * configuration.
	 * 
	 * @param color The team's color.
	 * 
	 * @return An optional that contains the team if, a team has the given color, an empty optional otherwise.
	 */
	Optional<ITeam> getTeam(EColor color);

	/**
	 * Get the team whose name is the given name. To do this, this method search the name of each team registered into this
	 * configuration.
	 * 
	 * @param teamName The team's name.
	 * 
	 * @return An optional that contains the team if, a team has the given color, an empty optional otherwise.
	 */
	Optional<ITeam> getTeam(String teamName);

	/**
	 * If the player has been registered into a team for this configuration, then get the list of player of this team. The given
	 * player has been removed from this list. If the given player is not registered into a team for this configuration, the list is
	 * empty.
	 * 
	 * @param player The player used to get its colleagues.
	 * @return A list of player that correspond to the colleagues of given player, or an empty list.
	 */
	List<Player> getColleagues(Player player);

	/**
	 * Get a random player from the given player's team. If the player is not registered into a team, then the returned optional is
	 * empty.
	 * 
	 * @param player The player used to get a random colleague.
	 * 
	 * @return An optional that contains a random player if the given player is registered into a team, an empty optional otherwise.
	 */
	Optional<Player> getRandomColleague(Player player);

	/**
	 * Get a random player from the given player's team that verify the given predicate. If the player is not registered into a team,
	 * then the returned optional is empty.
	 * 
	 * @param player    The player used to get a random colleague.
	 * @param predicate A filter for the players from the given player's team.
	 * 
	 * @return An optional that contains a random player.
	 */
	Optional<Player> getRandomColleague(Player player, Predicate<Player> predicate);

	/**
	 * Teleport randomly each team of this configuration.
	 * 
	 * @param world  The world in which teams are teleported.
	 * @param center The center used to be sure the random location is inside the area represented by the center and the bound.
	 * @param bound  The bound used to define a random location.
	 */
	void teleportTeamsRandomly(World world, Block center, int bound);

	/**
	 * Add the given player to the team represented by the given name.
	 * 
	 * @param teamName   The name of the team that will get the given player.
	 * @param playerName The player's name to add to the team.
	 * 
	 * @return The team to which the player has been added.
	 * 
	 * @throws TeamNotFoundException            If the team associated to the given name does not exists for this configuration.
	 * @throws PlayerNotFoundException          If the player associated to the given name does not exist.
	 * @throws PlayerAlreadyRegisteredException If the player is already registered in a team for this configuration.
	 */
	ITeam add(String teamName, String playerName);

	/**
	 * Add each player from the array <code>playerNames</code> to the team represented by the given name.
	 * 
	 * @param teamName    The name of the team that will get the given player.
	 * @param playerNames The array that contains each player's name to add to the team.
	 * 
	 * @return The team to which the player has been added.
	 * 
	 * @throws TeamNotFoundException            If the team associated to the given name does not exists for this configuration.
	 * @throws PlayerNotFoundException          If a player associated to a name does not exist.
	 * @throws PlayerAlreadyRegisteredException If the player is already registered in a team for this configuration.
	 */
	ITeam add(String teamName, String[] playerNames);

	/**
	 * Add the given player to the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param player   The player to add to the team.
	 * 
	 * @return The team to which the player has been added.
	 * 
	 * @throws TeamNotFoundException            If the team associated to the given name does not exists for this configuration.
	 * @throws PlayerAlreadyRegisteredException If a player is already registered in a team for this configuration.
	 * 
	 * @see TeamHelper#addPlayer(String, Player)
	 */
	ITeam add(String teamName, Player player);

	/**
	 * Add each player in the list <code>players</code> to the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param players  The list of players to add to the team.
	 * 
	 * @return The team to which the player has been added.
	 * 
	 * @throws TeamNotFoundException            If the team associated to the given name does not exists for this configuration.
	 * @throws PlayerAlreadyRegisteredException If a player is already registered in a team for this configuration.
	 * 
	 * @see TeamHelper#addPlayer(String, Player)
	 */
	ITeam add(String teamName, List<Player> players);

	/**
	 * Remove the given player from its team.
	 * 
	 * @param playerName The player's name to remove from its team.
	 * @return The team from which the player has been removed.
	 * 
	 * @throws PlayerNotFoundException      If the player associated to the given name does not exist.
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 */
	ITeam removePlayer(String playerName);

	/**
	 * Remove each player present in the list <code>playerNames</code> from their teams.
	 * 
	 * @param playerNames The list of players to remove from the team.
	 * @return The list of teams from which players have been removed.
	 * 
	 * @throws PlayerNotFoundException      If a player associated to a name does not exist.
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 */
	List<ITeam> removePlayers(String[] playerNames);

	/**
	 * Remove the given player from its team.
	 * 
	 * @param player The player to remove from its team.
	 * @return The team from which the player has been removed.
	 * 
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 */
	ITeam removePlayer(Player player);

	/**
	 * Remove each player present in the list <code>players</code> from their teams.
	 * 
	 * @param players The list of players to remove from the team.
	 * @return The list of teams from which players have been removed.
	 * 
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 */
	List<ITeam> removePlayers(List<Player> players);

	/**
	 * Move the player associated to the given <code>playerName</code> into the team associated to the specified
	 * <code>teamName</code>. If the player was already into a team, he is removed from its older team.
	 * 
	 * @param playerName The player'name to move from its team to the other.
	 * @param teamName   The new team's name of the player.
	 * 
	 * @return An array of team that contains the initial team (the first) and the target team (the second).
	 * 
	 * @throws PlayerNotFoundException      If the player associated to the given name does not exist.
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 * @throws TeamNotFoundException        If the team does not exist for this configuration.
	 * @throws TeamsAreTheSameException     If the actual player's team is the target team.
	 */
	ITeam[] movePlayer(String playerName, String teamName);

	/**
	 * Move the given player into the specified team. If the player was already into a team, he is removed from its older team.
	 * 
	 * @param player     The player to move from its team to another.
	 * @param targetTeam The new player's team.
	 * 
	 * @throws PlayerNotRegisteredException If the player is not registered in a team for this configuration.
	 * @throws TeamsAreTheSameException     If the actual player's team is the target team.
	 */
	void movePlayer(Player player, ITeam targetTeam);

	/**
	 * To know if a player is alone in its team. If the player is not registered in team, returns true.
	 * 
	 * @param player The player used to know if it is alone are not in its team.
	 * 
	 * @return True if the given player is alone (ie has no colleague), false otherwise.
	 */
	boolean isAlone(Player player);

	/**
	 * To know if a player is alone in its team. If the player is not registered in team, returns true.
	 * 
	 * @param player    The player used to know if it is alone are not in its team.
	 * @param predicate A filter for the players from the given player's team.
	 * 
	 * @return True if the given player is alone (ie has no colleague), false otherwise.
	 */
	boolean isAlone(Player player, Predicate<Player> predicate);

	/**
	 * @return A stream that contains all colours not already used by teams of this configuration.
	 */
	Stream<EColor> getAvailableColors();

	/**
	 * @return A stream that contains all players not registered into a team for this configuration.
	 */
	Stream<Player> getFreePlayers();

	/**
	 * @return A stream that contains all registered players in a team for this configuration.
	 */
	Stream<Player> getNotFreePlayers();

	/**
	 * Get a stream that contains the name of each registered team for this configuration.
	 * 
	 * @param colored True if team's name are coloured, false otherwise.
	 * @return A stream that contains each team's name.
	 */
	Stream<String> getTeamNames(boolean colored);

	/**
	 * Get a stream that contains all registered teams that does not contains the given player.
	 * 
	 * @param playerName The player's name used to filter the list of team for this configuration.
	 * 
	 * @return A stream that contains all teams except the team of the given player.
	 * 
	 * @throws PlayerNotFoundException If the player associated to the given name does not exist.
	 */
	Stream<ITeam> getOtherTeams(String playerName);

	/**
	 * Change the name of the team associated to the <code>oldName</code> by the <code>newName</code>
	 * 
	 * @param oldName The team's name to rename.
	 * @param newName The new team's name.
	 * 
	 * @return The team that has been renamed.
	 * 
	 * @throws TeamNotFoundException                  If the team associated to the given name does not exists for this configuration.
	 * @throws TeamNameForbiddenException             If the new team's name is forbidden.
	 * @throws TeamWithSameNameAlreadyExistsException If the new team's name is already used by another team for this configuration.
	 */
	ITeam renameTeam(String oldName, String newName);

	/**
	 * Change the colour of the team associated to the <code>teamName</code> by the <code>newColor</code>
	 * 
	 * @param teamName The team's name to change the colour.
	 * @param newColor The new color's name of the team.
	 * 
	 * @return The team that has been updated.
	 * 
	 * @throws TeamNotFoundException                   If the team associated to the given name does not exists for this
	 *                                                 configuration.
	 * @throws ColorNotFoundException                  If the color's name does not correspond to an existing colour.
	 * @throws TeamWithSameColorAlreadyExistsException If the colour is already used by another team.
	 */
	ITeam modifyTeamColor(String teamName, String newColor);
}
