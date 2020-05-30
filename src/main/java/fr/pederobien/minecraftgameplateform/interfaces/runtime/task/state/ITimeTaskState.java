package fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state;

import java.time.LocalTime;

public interface ITimeTaskState extends Runnable {

	/**
	 * Modify the state of this time task to pause state.
	 */
	void pause();

	/**
	 * Modify the state of this time task to run state.
	 */
	void relaunched();

	/**
	 * Modify the state of this time task to initial state.
	 */
	void cancel();

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
