package fr.pederobien.minecraftgameplateform.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bukkit.plugin.Plugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.impl.parse.JarMinecraftDictionaryParser;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRuleHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPlayerQuitOrJoinEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPluginHelper;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObservableTimeLine;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;
import fr.pederobien.minecraftscoreboards.interfaces.IObjectiveUpdater;

public class Plateform {
	/**
	 * Path to folder plugins/minecraft-game-plateform
	 */
	public static final Path ROOT = Paths.get("plugins", "minecraft-game-plateform");

	private static IPlateformConfiguration configuration;

	public static void setPlateformConfiguration(IPlateformConfiguration configuration) {
		if (Plateform.configuration != null)
			throw new UnsupportedOperationException("The plugin is already defined for this plateform");
		Plateform.configuration = configuration;
	}

	public static IPlateformConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @return The version of this plugin.
	 */
	public static String getVersion() {
		return configuration.getVersion();
	}

	/**
	 * @return The name of this plugin.
	 */
	public static String getName() {
		return configuration.getName();
	}

	/**
	 * Get the name of the jar associated to the given plugin name. If there is any plugin registered, this throws a
	 * {@link NullPointerException}.
	 * 
	 * @param pluginName The name of the plugin.
	 * 
	 * @return The jar's name of the plugin associated to the given plugin name.
	 */
	public static String getJarName(String pluginName) {
		return configuration.getJarName(pluginName);
	}

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public static IGameConfigurationContext getGameConfigurationContext() {
		return configuration.getGameConfigurationContext();
	}

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public static IMinecraftNotificationCenter getNotificationCenter() {
		return configuration.getNotificationCenter();
	}

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	public static ICommandHelper getCommandHelper() {
		return configuration.getCommandHelper();
	}

	/**
	 * @return The center used to track persistence version update.
	 */
	public static IPersistenceCenter getPersistenceCenter() {
		return configuration.getPersistenceCenter();
	}

	/**
	 * @return The manager used to or create an helper associated to a configuration.
	 */
	public static IGameConfigurationHelper getOrCreateConfigurationHelper(IGameConfiguration configuration) {
		return Plateform.configuration.getOrCreateConfigurationHelper(configuration);
	}

	/**
	 * @return The helper used to have access to all registered plugins to this plugin.
	 */
	public static IPluginHelper getPluginHelper() {
		return configuration.getPluginHelper();
	}

	/**
	 * @return The helper used to register game rules to this plateform.
	 */
	public static IGameRuleHelper getGameRuleHelper() {
		return configuration.getGameRuleHelper();
	}

	/**
	 * @return The plugin associated to this plateform.
	 */
	public static Plugin getPlugin() {
		return configuration.getPlugin();
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
		return configuration.getDefaultDictionaryParser(name);
	}

	/**
	 * @return The objective updater used to display informations on each player screen.
	 */
	public static IObjectiveUpdater getObjectiveUpdater() {
		return configuration.getObjectiveUpdater();
	}

	/**
	 * @return A task that represent the time during a game. When calling method {@link ITimeTask#start(Plugin)}, the game time
	 *         changed each second and all registered observers are notified.
	 */
	public static ITimeTask getTimeTask() {
		return configuration.getTimeTask();
	}

	/**
	 * @return The time line associated to this plugin. The time line is particularly used to registered a time event. If you want to
	 *         be notified punctually during a game, this time line should be used. However, if you want to be notified each second,
	 *         then you should be registered as observer for the time task.
	 * 
	 * @see #getTimeTask()
	 */
	public static IObservableTimeLine getTimeLine() {
		return configuration.getTimeLine();
	}

	/**
	 * @return An event listener used to notify when a player quit or join the server.
	 */
	public static IPlayerQuitOrJoinEventListener getPlayerQuitOrJoinEventListener() {
		return configuration.getPlayerQuitOrJoinEventListener();
	}
}
