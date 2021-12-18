package fr.pederobien.minecraft.gameplateform.interfaces.observer;

import java.time.LocalTime;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.gameplateform.interfaces.element.ITeam;

public interface IObsGameConfiguration {

	/**
	 * Notify this observer when a team has been added to a configuration.
	 * 
	 * @param configuration The configuration in which the given a team has been added.
	 * @param team          The added team.
	 */
	void onTeamAdded(IGameConfiguration configuration, ITeam team);

	/**
	 * Notify this observer when a team has been removed from a configuration
	 * 
	 * @param configuration The configuration from which a team has been removed
	 * @param team          The removed team.
	 */
	void onTeamRemoved(IGameConfiguration configuration, ITeam team);

	/**
	 * Notify this observer when the pvp time has been modified.
	 * 
	 * @param configuration The configuration in which in pvp time has been modified.
	 * @param oldTime       The oldValue of the pvp time.
	 * @param newTime       The new value of the pvp time.
	 */
	void onPvpTimeChanged(IGameConfiguration configuration, LocalTime oldTime, LocalTime newTime);
}
