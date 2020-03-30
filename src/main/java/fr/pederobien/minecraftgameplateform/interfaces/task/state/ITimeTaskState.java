package fr.pederobien.minecraftgameplateform.interfaces.task.state;

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
	 * @return The increasing time managed by this state.
	 */
	LocalTime getIncreasingTime();

	/**
	 * @return The decreasing time managed by this state.
	 */
	LocalTime getDecreasingTime();

	/**
	 * @return The pause time managed by this state.
	 */
	LocalTime getPauseTime();
}
