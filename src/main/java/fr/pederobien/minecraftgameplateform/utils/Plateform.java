package fr.pederobien.minecraftgameplateform.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bukkit.plugin.Plugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.impl.parse.JarMinecraftDictionaryParser;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.PlateformPlugin;
import fr.pederobien.minecraftgameplateform.helpers.CommandHelper;
import fr.pederobien.minecraftgameplateform.helpers.ConfigurationHelperManager;
import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPluginManager;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftgameplateform.internal.PersistenceCenter;

public class Plateform {
	/**
	 * Path to folder plugins/minecraft-game-plateform
	 */
	public static final Path ROOT = Paths.get("plugins", "minecraft-game-plateform");

	private static Plugin plugin;
	private static JarMinecraftDictionaryParser parser;

	/**
	 * @return The version of this plugin.
	 */
	public static String getVersion() {
		return getPlugin().getDescription().getVersion();
	}

	/**
	 * @return The name of this plugin.
	 */
	public static String getName() {
		return getPlugin().getDescription().getName();
	}

	/**
	 * @return The jar's name of this plugin.
	 */
	public static String getMinecraftPluginName() {
		return getName().concat("-").concat(getVersion()).concat("-jwd").concat(".jar");
	}

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public static IGameConfigurationContext getGameConfigurationContext() {
		return GameConfigurationContext.getInstance();
	}

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public static IMinecraftNotificationCenter getNotificationCenter() {
		return NotificationCenter.getInstance();
	}

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	public static ICommandHelper getCommandHelper() {
		return CommandHelper.getInstance();
	}

	/**
	 * @return The center used to track persistence version update.
	 */
	public static IPersistenceCenter getPersistenceCenter() {
		return PersistenceCenter.getInstance();
	}

	/**
	 * @return The manager used to or create an helper associated to a configuration.
	 */
	public static IGameConfigurationHelper getOrCreateConfigurationHelper(IGameConfiguration configuration) {
		return ConfigurationHelperManager.getInstance().getOrCreateHelper(configuration);
	}

	/**
	 * @return The manager used to have access to all registered plugins to this plugin.
	 */
	public static IPluginManager getPluginManager() {
		return PluginManager.getInstance();
	}

	/**
	 * @return The plugin associated to this plateform.
	 */
	public static Plugin getPlugin() {
		return plugin;
	}

	/**
	 * Set the plugin associated to this plateform.
	 * 
	 * @param plugin The minecraft plugin represented by this plateform.
	 */
	public static void setPlugin(Plugin plugin) {
		if (Plateform.plugin != null)
			throw new UnsupportedOperationException("The plugin is already defined for this plateform");
		Plateform.plugin = plugin;
		getPluginManager().register(plugin);
	}

	/**
	 * Reset the plugin associated to this plateform. If this method is called by another plugin than the PlateformPlugin, an
	 * UnsupportedOperationException is thrown.
	 * 
	 * @param plugin The plugin that call the reset.
	 * 
	 * @see UnsupportedOperationException
	 */
	public static void reset(Plugin plugin) {
		if (!(plugin instanceof PlateformPlugin))
			throw new UnsupportedOperationException("The plugin can only be reset by PlateformPlugin");
		Plateform.plugin = null;
	}

	/**
	 * Get the default dictionary xml parser. For this parser, the dictionary file must looks like : </br>
	 * 
	 * &lt;dictionary&gt;</br>
	 * &lt;name&gt;Game&lt;/name&gt;
	 * </pre>
	 * </br>
	 * &lt;version&gt;1.0&lt;/version&gt;</br>
	 * &lt;locales&gt;</br>
	 * &lt;locale&gt;fr&lt;/locale&gt;</br>
	 * &lt;locale&gt;fr-FR&lt;/locale&gt;</br>
	 * &lt;locale&gt;fr-CA&lt;/locale&gt;</br>
	 * etc... </br>
	 * &lt;/locales&gt;</br>
	 * &lt;messages&gt;</br>
	 * &lt;message&gt;</br>
	 * &lt;code&gt;The code&lt;/code&gt;</br>
	 * &lt;value&gt;The value&lt;/value&gt;</br>
	 * &lt;/message&gt;</br>
	 * &lt;message&gt;</br>
	 * &lt;code permission="The permission"&gt;The code&lt;/code&gt;</br>
	 * &lt;value&gt;The value&lt;/value&gt;</br>
	 * &lt;/message&gt;</br>
	 * etc...</br>
	 * &lt;/messages&gt;</br>
	 * &lt;/dictionary&gt;</br>
	 * </br>
	 * The permission correspond to enumeration {@link Permission}.
	 * 
	 * @return A dictionary parser.
	 * 
	 * @see IDictionaryParser
	 */
	public static JarMinecraftDictionaryParser getDefaultDictionaryParser(String name) {
		return parser == null ? parser = new JarMinecraftDictionaryParser(name) : (JarMinecraftDictionaryParser) parser.setName(name);
	}
}
