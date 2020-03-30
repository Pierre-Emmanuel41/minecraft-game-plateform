package fr.pederobien.minecraftgameplateform.interfaces.runtime.task;

public interface ITimeTaskObserver {

	/**
	 * Method called by the given time task whenever its internal time has changed.
	 * 
	 * @param task The task used to get more informations about all times managed by the time task.
	 */
	void timeChanged(ITimeTask task);
}
