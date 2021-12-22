package fr.pederobien.minecraft.game.platform;

import java.nio.file.Path;
import java.nio.file.Paths;

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

	/**
	 * The objective updater used to display informations on each player screen.
	 */
	public static final IObjectiveUpdater OBJECTIVE_UPDATER;

	/**
	 * The time line associated to this plugin. The time line is particularly used to registered time events. If you want to be
	 * notified punctually during a game, this time line should be used. However, if you want to be notified each second, then you
	 * should be registered as observer for the time task.
	 */
	public static final ITimeLine TIME_LINE;

	static {
		OBJECTIVE_UPDATER = ObjectiveUpdater.getInstance(GamePlatformPlugin.instance());
		TIME_LINE = new TimeLine(GamePlatformPlugin.instance());
	}
}
