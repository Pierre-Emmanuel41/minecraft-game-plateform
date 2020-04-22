package fr.pederobien.minecraftgameplateform.interfaces.helpers;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.helper.TeamHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public interface IGameConfigurationHelper {

	/**
	 * Create a team and add it to this configuration if and only if the name and the color are not already used.
	 * 
	 * @param name  The team's name.
	 * @param color The team's color.
	 * 
	 * @return The created team.
	 * 
	 * @throws TeamWithSameNameAlreadyExistsException  If the name is already used by another team.
	 * @throws TeamWithSameColorAlreadyExistsException If the color is already used by another team.
	 */
	ITeam create(String name, EColor color);

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
	 * @throws TeamNotFoundException If the team associated to the given name does not exists for this configuration.
	 * 
	 * @see TeamHelper#addPlayer(String, Player)
	 */
	void add(String teamName, Player player);

	/**
	 * Remove the given player from the team represented by the given name.
	 * 
	 * @param teamName The name of the team that will get the given player.
	 * @param player   The player to add to the team.
	 * 
	 * @throws TeamNotFoundException If the team associated to the given name does not exists for this configuration.
	 * 
	 * @see TeamHelper#removePlayer(String, Player)
	 */
	void remove(String teamName, Player player);

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
}
