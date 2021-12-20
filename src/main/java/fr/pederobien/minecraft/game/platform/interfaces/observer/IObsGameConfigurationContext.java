package fr.pederobien.minecraft.game.platform.interfaces.observer;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public interface IObsGameConfigurationContext {

	/**
	 * Notify this observer when the configuration get a new configuration as the configuration to start using command /startgame.
	 * 
	 * @param oldConfiguration The old configuration of the context.
	 * @param newConfiguration The new configuration of the context.
	 */
	void onConfigurationChanged(IGameConfiguration oldConfiguration, IGameConfiguration newConfiguration);
}
