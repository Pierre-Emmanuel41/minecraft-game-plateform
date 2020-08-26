package fr.pederobien.minecraftgameplateform.pltf;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.impl.parse.JarMinecraftDictionaryParser;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.helpers.CommandHelper;
import fr.pederobien.minecraftgameplateform.helpers.ConfigurationHelperManager;
import fr.pederobien.minecraftgameplateform.helpers.GameRuleHelper;
import fr.pederobien.minecraftgameplateform.helpers.PluginHelper;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractNominable;
import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.impl.element.PlayerQuitOrJoinEventListener;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.TimeTask;
import fr.pederobien.minecraftgameplateform.impl.runtime.timeline.TimeLine;
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
import fr.pederobien.minecraftgameplateform.internal.PersistenceCenter;
import fr.pederobien.minecraftscoreboards.ObjectiveUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.IObjectiveUpdater;

public class PlateformConfiguration extends AbstractNominable implements IPlateformConfiguration {
	private static JarMinecraftDictionaryParser parser;
	private static IObjectiveUpdater updater;
	private Plugin plugin;
	private IPlayerQuitOrJoinEventListener playerQuitOrJoinEventListener;

	public PlateformConfiguration(Plugin plugin) {
		super(plugin.getName());
		this.plugin = plugin;
		getPluginHelper().register(plugin);
		updater = ObjectiveUpdater.getInstance(plugin);

		playerQuitOrJoinEventListener = new PlayerQuitOrJoinEventListener();
		playerQuitOrJoinEventListener.register(plugin);
	}

	@Override
	public String getVersion() {
		return getPlugin().getDescription().getVersion();
	}

	@Override
	public String getJarName(String pluginName) {
		return getPluginHelper().getPlugin(pluginName).get().getName().concat(".jar");
	}

	@Override
	public IGameConfigurationContext getGameConfigurationContext() {
		return GameConfigurationContext.getInstance();
	}

	@Override
	public IMinecraftNotificationCenter getNotificationCenter() {
		return NotificationCenter.getInstance();
	}

	@Override
	public ICommandHelper getCommandHelper() {
		return CommandHelper.getInstance();
	}

	@Override
	public IPersistenceCenter getPersistenceCenter() {
		return PersistenceCenter.getInstance();
	}

	@Override
	public IGameConfigurationHelper getOrCreateConfigurationHelper(IGameConfiguration configuration) {
		return ConfigurationHelperManager.getInstance().getOrCreateHelper(configuration);
	}

	@Override
	public IPluginHelper getPluginHelper() {
		return PluginHelper.getInstance();
	}

	@Override
	public IGameRuleHelper getGameRuleHelper() {
		return GameRuleHelper.getInstance();
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	@Override
	public JarMinecraftDictionaryParser getDefaultDictionaryParser(String name) {
		return parser == null ? parser = new JarMinecraftDictionaryParser(name) : (JarMinecraftDictionaryParser) parser.setName(name);
	}

	@Override
	public IObjectiveUpdater getObjectiveUpdater() {
		return updater;
	}

	@Override
	public ITimeTask getTimeTask() {
		return TimeTask.getInstance();
	}

	@Override
	public IObservableTimeLine getTimeLine() {
		return TimeLine.getInstance();
	}

	@Override
	public IPlayerQuitOrJoinEventListener getPlayerQuitOrJoinEventListener() {
		return playerQuitOrJoinEventListener;
	}
}
