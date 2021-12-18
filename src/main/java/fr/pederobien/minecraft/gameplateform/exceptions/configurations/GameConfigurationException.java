package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import fr.pederobien.minecraft.gameplateform.exceptions.MinecraftPlateformException;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public abstract class GameConfigurationException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private IGameConfiguration gameConfiguration;

	protected GameConfigurationException(IGameConfiguration gameConfiguration) {
		this.gameConfiguration = gameConfiguration;
	}

	/**
	 * @return The configuration in which an exception occurred.
	 */
	public IGameConfiguration getGameConfiguration() {
		return gameConfiguration;
	}
}
