package fr.pederobien.minecraft.game.platform.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bukkit.plugin.Plugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraft.game.platform.GamePlatformPlugin;
import fr.pederobien.minecraft.game.platform.helpers.CommandHelper;
import fr.pederobien.minecraft.game.platform.helpers.ConfigurationHelperManager;
import fr.pederobien.minecraft.game.platform.helpers.PluginHelper;
import fr.pederobien.minecraft.game.platform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraft.game.platform.impl.element.PlayerQuitOrJoinEventListener;
import fr.pederobien.minecraft.game.platform.impl.runtime.task.TimeTask;
import fr.pederobien.minecraft.game.platform.impl.runtime.timeline.TimeLine;
import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommand;
import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraft.game.platform.interfaces.element.IPlayerQuitOrJoinEventListener;
import fr.pederobien.minecraft.game.platform.interfaces.element.IPluginHelper;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraft.game.platform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraft.game.platform.interfaces.runtime.timeline.IObservableTimeLine;
import fr.pederobien.minecraft.game.platform.internal.IPersistenceCenter;
import fr.pederobien.minecraft.game.platform.internal.PersistenceCenter;
import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.impl.parse.JarMinecraftDictionaryParser;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftscoreboards.ObjectiveUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.IObjectiveUpdater;

public class Plateform {
	/**
	 * Path to folder plugins/minecraft-game-plateform
	 */
	public static final Path ROOT = Paths.get("plugins", "minecraft-game-plateform");

	private static JarMinecraftDictionaryParser parser;
	private static IObjectiveUpdater updater;
	private static IPlayerQuitOrJoinEventListener playerQuitOrJoinEventListener;

	static {
		Plateform.updater = ObjectiveUpdater.getInstance(GamePlatformPlugin.instance());
		Plateform.playerQuitOrJoinEventListener = new PlayerQuitOrJoinEventListener();
		playerQuitOrJoinEventListener.register(GamePlatformPlugin.instance());
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
	 * @return The helper used to have access to all registered plugins to this plugin.
	 */
	public static IPluginHelper getPluginHelper() {
		return PluginHelper.getInstance();
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

	/**
	 * @return The objective updater used to display informations on each player screen.
	 */
	public static IObjectiveUpdater getObjectiveUpdater() {
		return updater;
	}

	/**
	 * @return A task that represent the time during a game. When calling method {@link ITimeTask#start(Plugin)}, the game time
	 *         changed each second and all registered observers are notified.
	 */
	public static ITimeTask getTimeTask() {
		return TimeTask.getInstance();
	}

	/**
	 * @return The time line associated to this plugin. The time line is particularly used to registered a time event. If you want to
	 *         be notified punctually during a game, this time line should be used. However, if you want to be notified each second,
	 *         then you should be registered as observer for the time task.
	 * 
	 * @see #getTimeTask()
	 */
	public static IObservableTimeLine getTimeLine() {
		return TimeLine.getInstance();
	}

	/**
	 * @return An event listener used to notify when a player quit or join the server.
	 */
	public static IPlayerQuitOrJoinEventListener getPlayerQuitOrJoinEventListener() {
		return playerQuitOrJoinEventListener;
	}
}
