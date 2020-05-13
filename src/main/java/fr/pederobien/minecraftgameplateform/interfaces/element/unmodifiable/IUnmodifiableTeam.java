package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.util.List;
import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

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

	/**
	 * Get an optional of {@link Team}. The team correspond to the team on the server associated to this {@link ITeam}. If this team
	 * is not created on the server, or has been created then removed, the optional is empty.
	 * 
	 * @return An optional that contains the server team if created on server, an empty optional otherwise.
	 * 
	 * @see IUnmodifiableTeam#isCreatedOnServer()
	 */
	Optional<Team> getServerTeam();
}
