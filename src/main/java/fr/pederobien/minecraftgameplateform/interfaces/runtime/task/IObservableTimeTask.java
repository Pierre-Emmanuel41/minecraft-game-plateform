package fr.pederobien.minecraftgameplateform.interfaces.runtime.task;

public interface IObservableTimeTask {

	/**
	 * Add an observer to this observable time task. The given observer is notified whenever the internal time of this task has
	 * changed.
	 * 
	 * @param obs The observer to notify.
	 */
	void addObserver(IObsTimeTask obs);

	/**
	 * Remove the given observer from the list of observers for this observable time task. The given observer is not notified any more
	 * when the internal time of this task has changed.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeObserver(IObsTimeTask obs);
}
