package fr.pederobien.minecraft.gameplateform.interfaces.runtime.task;

public interface IObsTimeTask {

	/**
	 * Notify this observer the given time task has been started.
	 * 
	 * @param task The started time task.
	 */
	void onStart(ITimeTask task);

	/**
	 * Notify this observer the given time task has been paused.
	 * 
	 * @param task The pause time task.
	 */
	void onPause(ITimeTask task);

	/**
	 * Notify this observer the given time task has been relaunched.
	 * 
	 * @param task The relaunched task.
	 */
	void onRelaunched(ITimeTask task);

	/**
	 * Notify this observer the given time task has been stopped.
	 * 
	 * @param task The stopped time task.
	 */
	void onStop(ITimeTask task);

	/**
	 * Notify this observer the internal task of the given time task has changed.
	 * 
	 * @param task The task used to get more informations about all times managed by the time task.
	 */
	void timeChanged(ITimeTask task);
}
