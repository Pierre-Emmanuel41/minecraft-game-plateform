package fr.pederobien.minecraft.game.platform;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.pederobien.minecraft.game.impl.time.TimeLine;
import fr.pederobien.minecraft.game.interfaces.time.ITimeLine;
import fr.pederobien.minecraft.game.platform.helpers.CommandHelper;
import fr.pederobien.minecraft.game.platform.helpers.PluginHelper;
import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommand;
import fr.pederobien.minecraft.game.platform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraft.game.platform.interfaces.element.IPluginHelper;
import fr.pederobien.minecraft.game.platform.internal.IPersistenceCenter;
import fr.pederobien.minecraft.game.platform.internal.PersistenceCenter;
import fr.pederobien.minecraft.scoreboards.ObjectiveUpdater;
import fr.pederobien.minecraft.scoreboards.interfaces.IObjectiveUpdater;
import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;

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
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public static IMinecraftNotificationCenter getNotificationCenter() {
		return NotificationCenter.getInstance();
	}

	/**
	 * @return The helper used to have access to all registered plugins to this plugin.
	 */
	public static IPluginHelper getPluginHelper() {
		return PluginHelper.getInstance();
	}
}
