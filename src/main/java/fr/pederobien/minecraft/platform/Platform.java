package fr.pederobien.minecraft.platform;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.game.impl.time.TimeLine;
import fr.pederobien.minecraft.game.interfaces.time.ITimeLine;
import fr.pederobien.minecraft.scoreboards.ObjectiveUpdater;
import fr.pederobien.minecraft.scoreboards.interfaces.IObjectiveUpdater;

public class Platform {
	/**
	 * The path leading to the plugins folder.
	 */
	public static final Path PLUGINS = Paths.get("plugins");

	/**
	 * Path to folder plugins/minecraft-game-plateform
	 */
	public static final Path ROOT = PLUGINS.resolve("minecraft-game-plateform");

	private static final Map<Plugin, Platform> PLATFORMS = new HashMap<Plugin, Platform>();
	private IObjectiveUpdater objectiveUpdater;
	private ITimeLine timeLine;

	/**
	 * Get the platform instance associated to the given plugin. The returned platform is not null if and only if the game associated
	 * to the plugin is started.
	 * 
	 * @param plugin The plugin used to get the associated platform.
	 * 
	 * @return The platform instance.
	 */
	public static Platform get(Plugin plugin) {
		return PLATFORMS.get(plugin);
	}

	/**
	 * Creates a new platform instance associated to the given plugin.
	 * 
	 * @param plugin The plugin that contains a started game.
	 */
	protected static void register(Plugin plugin) {
		Platform platform = PLATFORMS.get(plugin);
		if (platform != null)
			return;

		platform = new Platform(plugin);
		PLATFORMS.put(plugin, platform);
	}

	/**
	 * Removes the platform associated to the given plugin.
	 * 
	 * @param plugin The plugin that contains a started game.
	 */
	protected static void unregister(Plugin plugin) {
		Platform platform = PLATFORMS.remove(plugin);

		if (platform == null)
			return;

		platform.getObjectiveUpdater().stop(true);
		platform.getTimeLine().getTimeTask().stop();
	}

	/**
	 * Creates a new platform based on the given plugin.
	 * 
	 * @param plugin The plugin associated to this platform.
	 */
	private Platform(Plugin plugin) {
		objectiveUpdater = ObjectiveUpdater.getInstance(plugin);
		objectiveUpdater.start();

		timeLine = new TimeLine(plugin);
		timeLine.getTimeTask().start();
	}

	/**
	 * The time line associated to this platform. The time line is particularly used to registered time events. If you want to be
	 * notified punctually during a game, this time line should be used. However, if you want to be notified each second, then you
	 * should be registered as observer for the time task.
	 * 
	 * @return The time associated to this platform.
	 */
	public ITimeLine getTimeLine() {
		return timeLine;
	}

	/**
	 * The objective updater used to display informations on each player screen.
	 */
	public IObjectiveUpdater getObjectiveUpdater() {
		return objectiveUpdater;
	}
}
