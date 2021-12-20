package fr.pederobien.minecraft.game.platform.interfaces.observer;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraftmanagers.EColor;

public interface IObsTeam {

	/**
	 * Notify this observer when the name of the given team has changed.
	 * 
	 * @param team    The modified team.
	 * @param oldName The old name of the team.
	 * @param newName The new name of the team.
	 */
	void onNameChanged(ITeam team, String oldName, String newName);

	/**
	 * Notify this observer when the color of the given team has changed.
	 * 
	 * @param team     The modified team.
	 * @param oldColor The old color of the given team.
	 * @param newColor The new color of team.
	 */
	void onColorChanged(ITeam team, EColor oldColor, EColor newColor);

	/**
	 * Notify this observer when a player is added to the given team.
	 * 
	 * @param team   The modified team.
	 * @param player The player added to the team.
	 */
	void onPlayerAdded(ITeam team, Player player);

	/**
	 * Notify this observer when a player is removed from the given team.
	 * 
	 * @param team   The modified team.
	 * @param player The player removed from the team.
	 */
	void onPlayerRemoved(ITeam team, Player player);

	/**
	 * Notify this observer when the given team has been cloned.
	 * 
	 * @param team The original team that has been cloned.
	 */
	void onClone(ITeam team);
}
