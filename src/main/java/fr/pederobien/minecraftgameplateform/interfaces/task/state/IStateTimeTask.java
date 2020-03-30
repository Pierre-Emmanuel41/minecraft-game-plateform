package fr.pederobien.minecraftgameplateform.interfaces.task.state;

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
}
