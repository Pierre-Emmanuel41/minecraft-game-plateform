package fr.pederobien.minecraftgameplateform.interfaces.element;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableTeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public interface ITeam extends IUnmodifiableTeam {

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

	/***
	 * True if this team has been created on the server, false otherwise.
	 * 
	 * @param isCreatedOnServer Boolean that describe if this team has been created on the server.
	 */
	void setCreatedOnServer(boolean isCreatedOnServer);
}