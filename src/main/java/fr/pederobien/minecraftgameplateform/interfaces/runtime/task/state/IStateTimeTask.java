package fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state;

import org.bukkit.scheduler.BukkitTask;

public interface IStateTimeTask {

	/**
	 * @return The current state of this time task.
	 * 
	 */
	ITimeTaskState getCurrentState();

	/**
	 * Set the current state of this time task.
	 * 
	 * @param current The new current state.
	 * 
	 * @return The given state.
	 */
	ITimeTaskState setCurrentState(ITimeTaskState current);

	/**
	 * @return The initial state of this time task.
	 */
	ITimeTaskState getInitialState();

	/**
	 * @return The pause state of this time task.
	 */
	ITimeTaskState getPauseState();

	/**
	 * @return The run state of this time task.
	 */
	ITimeTaskState getRunState();

	/**
	 * @return A task that will repeatedly run until cancelled.
	 */
	BukkitTask getBukkitTask();

	/**
	 * Set the bukkit task associated to this time task. This bukkit task is particularly used to cancel this task.
	 * 
	 * @param task The bukkit task equivalent for this task.
	 */
	void setBukkitTask(BukkitTask task);
}
