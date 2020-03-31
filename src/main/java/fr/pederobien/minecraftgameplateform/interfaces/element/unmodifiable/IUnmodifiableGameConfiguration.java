package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.util.List;
import java.util.Optional;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public interface IUnmodifiableGameConfiguration extends IUnmodifiableNominable {

	/**
	 * @return The game managed by this configuration.
	 */
	IGame getGame();

	/**
	 * @return The list of registered team associated to this configuration. This list is unmodifiable.
	 */
	List<ITeam> getTeams();

	/**
	 * Get the team in this configuration associated to the given name.
	 * 
	 * @param name The name used to obtain the associated team.
	 * 
	 * @return An optional that contains the team if it exists, a empty optional otherwise.
	 */
	Optional<ITeam> getTeam(String name);

	/**
	 * @return The refresh scoreboard period, in server ticks.
	 */
	Long getScoreboardRefresh();

	/**
	 * @return The list of each player registered in teams for this configuration. This list is unmodifiable.
	 */
	List<Player> getRegisteredPlayers();
}
