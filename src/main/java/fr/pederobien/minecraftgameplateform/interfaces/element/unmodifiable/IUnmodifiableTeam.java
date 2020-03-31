package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.util.List;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.utils.EColor;

public interface IUnmodifiableTeam extends IUnmodifiableNominable {

	/**
	 * @return The name of this team using {@link EColor#getInColor(String)} with parameters String equals {@link #getName()}.
	 */
	String getColoredName();

	/**
	 * @return The color of this team. The default value is {@link EColor#RESET}.
	 */
	EColor getColor();

	/**
	 * @return The list of players registered in this team. This list is unmodifiable.
	 */
	List<Player> getPlayers();

	/**
	 * @return If this team has been created on this server.
	 */
	boolean isCreatedOnServer();
}
