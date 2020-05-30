package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableGameConfiguration;

public interface IGameConfiguration extends IUnmodifiableGameConfiguration {

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
}
