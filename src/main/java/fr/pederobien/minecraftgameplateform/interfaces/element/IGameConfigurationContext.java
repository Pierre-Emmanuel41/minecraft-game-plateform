package fr.pederobien.minecraftgameplateform.interfaces.element;

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
}
