package fr.pederobien.minecraftgameplateform.interfaces.runtime.launchers;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public interface ILauncher {

	/**
	 * Schedules this to repeatedly run until cancelled, starting after the specified number of server ticks.
	 *
	 * @param plugin the reference to the plugin scheduling task.
	 * @param delay  the ticks to wait before running the task.
	 * @param period the ticks to wait between runs.
	 * 
	 * @throws IllegalArgumentException if plugin is null.
	 * @throws IllegalStateException    if this was already scheduled.
	 * @see BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
	 */
	void run(Plugin plugin, long delay, long period);

	/**
	 * Modify the state of this launcher to pause state.
	 */
	void pause();

	/**
	 * Modify the state of this launcher to initial state.
	 */
	void cancel();

	/**
	 * Modify the state of this launcher to run state.
	 */
	void relaunched();
}
