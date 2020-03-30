package fr.pederobien.minecraftgameplateform.interfaces.task.state;

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
}
