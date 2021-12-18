package fr.pederobien.minecraft.gameplateform.interfaces.runtime.task.state;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;

public interface ITimeTaskState extends Runnable {

	/**
	 * Start this time task. The given plugin is necessary to schedule this task.
	 * 
	 * @param plugin The plugin associated to this task.
	 */
	void start(Plugin plugin);

	/**
	 * Modify the state of this time task to pause state.
	 */
	void pause();

	/**
	 * Modify the state of this time task to run state.
	 */
	void relaunched();

	/**
	 * Reset all parameters managed by this time task
	 */
	void stop();

	/**
	 * @return The total time managed by this state.
	 */
	LocalTime getTotalTime();

	/**
	 * @return The game time managed by this state.
	 */
	LocalTime getGameTime();

	/**
	 * @return The pause time managed by this state.
	 */
	LocalTime getPauseTime();
}
