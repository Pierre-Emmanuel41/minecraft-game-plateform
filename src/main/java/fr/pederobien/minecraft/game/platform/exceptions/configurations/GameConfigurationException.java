package fr.pederobien.minecraft.game.platform.exceptions.configurations;

import fr.pederobien.minecraft.game.platform.exceptions.MinecraftPlateformException;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

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
