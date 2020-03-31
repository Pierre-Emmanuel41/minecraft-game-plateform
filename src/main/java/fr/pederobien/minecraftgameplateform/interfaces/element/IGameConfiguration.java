package fr.pederobien.minecraftgameplateform.interfaces.element;

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
	 * Set the refresh scoreboard period, in server ticks.
	 * 
	 * @param refresh The scoreboard refresh period.
	 */
	void setScoreboardRefresh(long refresh);
}
