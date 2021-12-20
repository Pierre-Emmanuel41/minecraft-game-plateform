package fr.pederobien.minecraft.game.platform.helpers;

import java.util.HashMap;
import java.util.Map;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IConfigurationHelperManager;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IGameConfigurationHelper;

public class ConfigurationHelperManager implements IConfigurationHelperManager {
	private Map<IGameConfiguration, IGameConfigurationHelper> helpers;

	private ConfigurationHelperManager() {
		helpers = new HashMap<IGameConfiguration, IGameConfigurationHelper>();
	}

	public static IConfigurationHelperManager getInstance() {
		return SingletonHolder.MANAGER;
	}

	private static class SingletonHolder {
		private static final IConfigurationHelperManager MANAGER = new ConfigurationHelperManager();
	}

	@Override
	public IGameConfigurationHelper getOrCreateHelper(IGameConfiguration configuration) {
		IGameConfigurationHelper helper = helpers.get(configuration);
		if (helper == null) {
			helper = new GameConfigurationHelper(configuration);
			helpers.put(configuration, helper);
		}
		return helper;
	}
}
