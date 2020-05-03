package fr.pederobien.minecraftgameplateform.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.interfaces.INotificationCenter;
import fr.pederobien.minecraftgameplateform.helpers.CommandHelper;
import fr.pederobien.minecraftgameplateform.helpers.ConfigurationHelperManager;
import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPluginManager;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IConfigurationHelperManager;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftgameplateform.internal.PersistenceCenter;

public class Plateform {
	public static final Path ROOT = Paths.get("plugins", "minecraft-game-plateform");
	private static final String MINECRAFT_GAME_PLATEFORM = "minecraft-game-plateform";
	private static IGameConfigurationContext gameContext = GameConfigurationContext.getInstance();
	private static INotificationCenter notificationCenter = NotificationCenter.getInstance();
	private static ICommandHelper commandHelper = CommandHelper.getInstance();
	private static IPersistenceCenter persistenceCenter = PersistenceCenter.getInstance();
	private static IConfigurationHelperManager configurationHelperManager = ConfigurationHelperManager.getInstance();
	private static IPluginManager pluginManager = PluginManager.getInstance();

	/**
	 * @return The version of this plugin.
	 */
	public static String getVersion() {
		return "v1.0-SNAPSHOT";
	}

	/**
	 * @return The name of this plugin.
	 */
	public static String getName() {
		return MINECRAFT_GAME_PLATEFORM;
	}

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public static IGameConfigurationContext getGameConfigurationContext() {
		return gameContext;
	}

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public static INotificationCenter getNotificationCenter() {
		return notificationCenter;
	}

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	public static ICommandHelper getCommandHelper() {
		return commandHelper;
	}

	/**
	 * @return The center used to track persistence version update.
	 */
	public static IPersistenceCenter getPersistenceCenter() {
		return persistenceCenter;
	}

	/**
	 * @return The manager used to or create an helper associated to a configuration.
	 */
	public static IGameConfigurationHelper getOrCreateConfigurationHelper(IGameConfiguration configuration) {
		return configurationHelperManager.getOrCreateHelper(configuration);
	}

	/**
	 * @return The manager used to have access to all registered plugins to this plugin.
	 */
	public static IPluginManager getPluginManager() {
		return pluginManager;
	}
}
