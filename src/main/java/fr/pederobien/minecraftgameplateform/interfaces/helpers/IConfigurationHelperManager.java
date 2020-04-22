package fr.pederobien.minecraftgameplateform.interfaces.helpers;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

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
