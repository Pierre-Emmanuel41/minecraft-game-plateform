package fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;

public interface ITimeLinePeriodicObserver extends IObsTimeLine {

	/**
	 * @return The period used to notify the observer.
	 */
	LocalTime getPeriod();

	/**
	 * @return The time at which the observer is notified.
	 */
	LocalTime getNextNotifyTime();

	/**
	 * Set the next time at which the observer is notified.
	 * 
	 * @param time The time at which the observer will be notified.
	 */
	void setNextNotifyTime(LocalTime time);

	/**
	 * Notify this observer that the current time has changed. This method is called whenever the internal time of the
	 * {@link ITimeTask} has changed.
	 */
	void notifyCurrentTimeChanged();

}
