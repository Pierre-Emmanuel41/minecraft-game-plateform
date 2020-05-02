package fr.pederobien.minecraftgameplateform.interfaces.element;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableTeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public interface ITeam extends INominable, IUnmodifiableTeam {

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
}
