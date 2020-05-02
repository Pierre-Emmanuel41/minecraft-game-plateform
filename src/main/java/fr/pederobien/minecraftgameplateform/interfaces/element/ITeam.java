package fr.pederobien.minecraftgameplateform.interfaces.element;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableTeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public interface ITeam extends INominable, IUnmodifiableTeam {

	/**
	 * Set the color of this team.
	 * 
	 * @param color The new color of this team.
	 */
	void setColor(EColor color);

	/**
	 * Append the given player to this team. This method update the player's displayName by adding the color of this team.
	 * 
	 * @param player The player to add.
	 */
	void addPlayer(Player player);

	/**
	 * Remove the player from this team. This method update the player's displayName by removing the color of this team.
	 * 
	 * @param player The player to remove.
	 */
	void removePlayer(Player player);

	/**
	 * Remove all registered players.
	 */
	void clear();

	/**
	 * Clone this team. The returned team will have the same name, the same color and the same players than this original team. One
	 * thing differ slightly is the behaviour. When players are added or remove from the clone team, the display name of players is
	 * not updated.
	 * 
	 * @return The clone of this team.
	 */
	ITeam clone();
}
