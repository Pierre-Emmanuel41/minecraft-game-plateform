package fr.pederobien.minecraft.gameplateform.interfaces.element;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraft.gameplateform.interfaces.observer.IObsGameConfiguration;

public interface IGameConfiguration extends INominable {

	/**
	 * @return The game managed by this configuration.
	 */
	IGame getGame();

	/**
	 * Append the given team to this configuration.
	 * 
	 * @param team The team to add.
	 */
	void add(ITeam team);

	/**
	 * Remove the given team from this configuration.
	 * 
	 * @param team The team to remove.
	 */
	void remove(ITeam team);

	/**
	 * Remove each team in the given list <code>teams</code> from this configuration.
	 * 
	 * @param teams The list of team to remove from this configuration.
	 */
	void removeTeams(List<ITeam> teams);

	/**
	 * Remove each registered team from this configuration.
	 * 
	 * @return The list of removed teams.
	 */
	List<ITeam> clearTeams();

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
	 * @return The time after which the pvp is enabled.
	 */
	LocalTime getPvpTime();

	/**
	 * While the game time is less than the given time, the pvp is deactivated.
	 * 
	 * @param pvpTime The time after which the pvp is enabled.
	 */
	void setPvpTime(LocalTime pvpTime);

	/**
	 * Append an observer for this configuration.
	 * 
	 * @param obs The observer to add.
	 */
	void addObserver(IObsGameConfiguration obs);

	/**
	 * Removes the given observer from the list of observer for this configuration.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeObserver(IObsGameConfiguration obs);
}
