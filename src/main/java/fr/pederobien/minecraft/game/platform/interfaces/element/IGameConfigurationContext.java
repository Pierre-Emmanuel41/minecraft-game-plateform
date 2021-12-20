package fr.pederobien.minecraft.game.platform.interfaces.element;

import fr.pederobien.minecraft.game.platform.interfaces.observer.IObsGameConfigurationContext;

public interface IGameConfigurationContext extends IGameConfiguration, IGame {

	/**
	 * Set the current game configuration this context is in charge of.
	 * 
	 * @param configuration The new current configuration.
	 */
	void setGameConfiguration(IGameConfiguration gameConfiguration);

	/**
	 * @return The current game configuration this context is in charge of.
	 */
	IGameConfiguration getGameConfiguration();

	/**
	 * Appends an observer for this game configuration context.
	 * 
	 * @param obs The observer to add.
	 */
	void addContextObserver(IObsGameConfigurationContext obs);

	/**
	 * Removes an observer for this game configuration context.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeContextObserver(IObsGameConfigurationContext obs);
}
