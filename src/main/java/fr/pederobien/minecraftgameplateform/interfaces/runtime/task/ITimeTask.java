package fr.pederobien.minecraftgameplateform.interfaces.runtime.task;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public interface ITimeTask extends ITimeTaskState, Runnable {

	/**
	 * Reset all parameters managed by this time task
	 */
	void cancel();

	/**
	 * Modify the state of this time task to pause state. The internal total time is still updated, the increasing and decreasing time
	 * are not updated any more, the pause time is updated.
	 */
	void pause();

	/**
	 * Modify the state of this time task to run state. The internal total time is still updated, the pause time is not updated any
	 * more, the increasing and decreasing time are updated.
	 */
	void relaunched();

	/**
	 * Get the time since the first call to the {@link #run()} method. If the {@link #cancel()} method has been called, this time has
	 * been reset. This update of this time is not impacted by the call to the {@link #pause()} method.
	 * 
	 * @return The internal total time managed by this time task.
	 */
	LocalTime getTotalTime();

	/**
	 * Get the time that is increased by one second whenever the method {@link #run()} is called. If the {@link #pause()} method has
	 * not been called, it correspond to the total time. When the method pause() has been called, this time not updated until the
	 * {@link #relaunched()} method is called.
	 * 
	 * @return The game time managed by this time task.
	 */
	public LocalTime getGameTime();

	/**
	 * Get the time that is decreased by one second whenever the method {@link #run()} is called. If the {@link #pause()} method has
	 * been called, this time is not updated until the {@link #relaunched()} method is called.
	 * 
	 * @return The decreasing time managed by this task.
	 */
	public LocalTime getDecreasingTime();

	/**
	 * Get the time that is increased by one second whenever the method {@link #run()} is called if and only if the {@link #pause()}
	 * method has been called before. If the {@link #pause()} method has not been called, it correspond to the time 00:00:00. When the
	 * method {@link #relaunched()} is called, this time not updated until the {@link #pause()} method is called.
	 * 
	 * @return The pause time managed by this time task.
	 */
	public LocalTime getPauseTime();
}
