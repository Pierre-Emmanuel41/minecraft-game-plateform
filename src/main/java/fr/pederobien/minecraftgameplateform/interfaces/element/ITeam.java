package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;
import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsPlayerQuitOrJoinEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsTeam;
import fr.pederobien.minecraftmanagers.EColor;

public interface ITeam extends INominable, IObsPlayerQuitOrJoinEventListener {

	/**
	 * @return The name of this team using {@link EColor#getInColor(String)} with parameters String equals {@link #getName()}.
	 */
	String getColoredName();

	/**
	 * @return The color of this team. The default value is {@link EColor#RESET}.
	 */
	EColor getColor();

	/**
	 * Set the color of this team. If this team has been created on the server and is not a clone, then the "server team" is also
	 * updated.
	 * 
	 * @param color The new color of this team.
	 */
	void setColor(EColor color);

	/**
	 * Append the given player to this team. If this team has been created on the server and is not a clone, then the "server team" is
	 * also updated.
	 * 
	 * @param player The player to add.
	 */
	void addPlayer(Player player);

	/**
	 * Remove the player from this team. If this team has been created on the server and is not a clone, then the "server team" is
	 * also updated.
	 * 
	 * @param player The player to remove.
	 */
	void removePlayer(Player player);

	/**
	 * @return The list of players registered in this team. This list is unmodifiable.
	 */
	List<Player> getPlayers();

	/**
	 * Remove all registered players. If this team has been created on the server and is not a clone, then the "server team" is also
	 * updated.
	 */
	void clear();

	/**
	 * Clone this team. The returned team will have the same name, the same color and the same players than the original team. One
	 * thing differ slightly is the behaviour. Because the returned team is a clone, the associated server team is not updated if
	 * there are modifications.
	 * 
	 * @return The clone of this team.
	 */
	ITeam clone();

	/**
	 * Append an observer for this team.
	 * 
	 * @param obs The observer to add.
	 */
	void addObserver(IObsTeam obs);

	/**
	 * Removes the given observers from the list of observer for this team.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeObserver(IObsTeam obs);

	/**
	 * @return If this team has been created on this server.
	 */
	boolean isCreatedOnServer();

	/**
	 * Get an optional of {@link Team}. The team correspond to the team on the server associated to this {@link ITeam}. If this team
	 * is not created on the server, or has been created then removed, the optional is empty.
	 * 
	 * @return An optional that contains the server team if created on server, an empty optional otherwise.
	 * 
	 * @see #isCreatedOnServer()
	 */
	Optional<Team> getServerTeam();
}
