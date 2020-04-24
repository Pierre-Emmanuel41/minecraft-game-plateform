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
	 * Remove each registered team from this configuration.
	 * 
	 * @return The list of removed teams.
	 */
	List<ITeam> clear();

	/**
	 * Set the refresh scoreboard period, in server ticks.
	 * 
	 * @param refresh The scoreboard refresh period.
	 */
	void setScoreboardRefresh(long refresh);
}
