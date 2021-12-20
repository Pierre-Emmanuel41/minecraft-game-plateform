package fr.pederobien.minecraft.game.platform.interfaces.helpers;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public interface IConfigurationHelperManager {

	/**
	 * Get the helper associated to the specified configuration.
	 * 
	 * @param configuration The configuration used to get its helper.
	 * 
	 * @return The helper if it has been registered.
	 */
	IGameConfigurationHelper getOrCreateHelper(IGameConfiguration configuration);
}
