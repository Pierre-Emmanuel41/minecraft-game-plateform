package fr.pederobien.minecraftgameplateform.interfaces.helpers;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.helpers.TeamHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

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
	ITeam remove(String teamName);

	/**
	 * Remove each team associated to the name in the <code>teamNames</code> if it exist.
	 * 
	 * @param teamNames The name of each team to remove.
	 * 
	 * @return The list of removed teams.
	 * 
	 * @throws TeamNotFoundException If a team associated to a name does not exists for this configuration.
	 */
	List<ITeam> remove(String[] teamNames);

	/**
	 * Remove all registered teams for this configuration.
	 * 
	 * @return The list of removed teams.
	 */
	List<ITeam> clear();

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
	 * @param world The world in which teams are teleported.
	 * @param bound The bound used to define a random location.
	 */
	void teleportTeamsRandomly(World world, int bound);

	/**
	 * Add the given player to the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param player   The player to add to the team.
	 * 
	 * @return The team to which the player has been added.
	 * 
	 * @throws TeamNotFoundException            If the team associated to the given name does not exists for this configuration.
	 * @throws PlayerAlreadyRegisteredException If the player is already registered in a team for this configuration.
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
	 * Remove the given player from the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param player   The player to add to the team.
	 * 
	 * @return The team from which the player has been removed.
	 * 
	 * @throws TeamNotFoundException If the team associated to the given name does not exists for this configuration.
	 * 
	 * @see TeamHelper#removePlayer(String, Player)
	 */
	ITeam remove(String teamName, Player player);

	/**
	 * Remove each player present in the list <code>players</code> from the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param players  The list of players to remove from the team.
	 * 
	 * @return The team from which the player has been removed.
	 * 
	 * @throws TeamNotFoundException If the team associated to the given name does not exists for this configuration.
	 * 
	 * @see TeamHelper#removePlayer(String, Player)
	 */
	ITeam remove(String teamName, List<Player> players);

	/**
	 * Move the given player into the team associated to the specified <code>teamName</code>. If the player was already into a team,
	 * he is removed from its older team.
	 * 
	 * @param player   The player to add.
	 * @param teamName The team's name of the player's team.
	 * 
	 * @throws TeamNotFoundException if the team does not exist for this configuration.
	 */
	void movePlayer(Player player, String teamName);

	/**
	 * @return A stream that contains all colours not already used by teams of this configuration.
	 */
	Stream<EColor> getAvailableColors();

	/**
	 * @return A stream that contains all players not registered into a team for this configuration.
	 */
	Stream<Player> getFreePlayers();

	/**
	 * Get a stream that contains the name of each registered team for this configuration.
	 * 
	 * @param colored True if team's name are coloured, false otherwise.
	 * @return A stream that contains each team's name.
	 */
	Stream<String> getTeamNames(boolean colored);
}
