package fr.pederobien.minecraftgameplateform.pltf;

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
import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPlayerQuitOrJoinEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPluginHelper;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObservableTimeLine;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftscoreboards.interfaces.IObjectiveUpdater;

public interface IPlateformConfiguration extends INominable {

	/**
	 * @return The version of this plugin.
	 */
	public String getVersion();

	/**
	 * @return The name of this plugin.
	 */
	public String getName();

	/**
	 * Get the name of the jar associated to the given plugin name. If there is any plugin registered, this throws a
	 * {@link NullPointerException}.
	 * 
	 * @param pluginName The name of the plugin.
	 * 
	 * @return The jar's name of the plugin associated to the given plugin name.
	 */
	public String getJarName(String pluginName);

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public IGameConfigurationContext getGameConfigurationContext();

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public IMinecraftNotificationCenter getNotificationCenter();

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	public ICommandHelper getCommandHelper();

	/**
	 * @return The center used to track persistence version update.
	 */
	public IPersistenceCenter getPersistenceCenter();

	/**
	 * @return The manager used to or create an helper associated to a configuration.
	 */
	public IGameConfigurationHelper getOrCreateConfigurationHelper(IGameConfiguration configuration);

	/**
	 * @return The helper used to have access to all registered plugins to this plugin.
	 */
	public IPluginHelper getPluginHelper();

	/**
	 * @return The helper used to register game rules to this plateform.
	 */
	public IGameRuleHelper getGameRuleHelper();

	/**
	 * @return The plugin associated to this plateform.
	 */
	public Plugin getPlugin();

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
	public JarMinecraftDictionaryParser getDefaultDictionaryParser(String name);

	/**
	 * @return The objective updater used to display informations on each player screen.
	 */
	public IObjectiveUpdater getObjectiveUpdater();

	/**
	 * @return A task that represent the time during a game. When calling method {@link ITimeTask#start(Plugin)}, the game time
	 *         changed each second and all registered observers are notified.
	 */
	public ITimeTask getTimeTask();

	/**
	 * @return The time line associated to this plugin. The time line is particularly used to registered a time event. If you want to
	 *         be notified punctually during a game, this time line should be used. However, if you want to be notified each second,
	 *         then you should be registered as observer for the time task.
	 * 
	 * @see #getTimeTask()
	 */
	public IObservableTimeLine getTimeLine();

	/**
	 * @return An event listener used to notify when a player quit or join the server.
	 */
	public IPlayerQuitOrJoinEventListener getPlayerQuitOrJoinEventListener();
}
