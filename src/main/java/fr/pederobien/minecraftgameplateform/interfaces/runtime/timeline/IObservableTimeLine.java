package fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline;

import java.time.LocalTime;

public interface IObservableTimeLine {

	/**
	 * Register the given observer for the specific time. It is possible to add several observers for the same time. It that case,
	 * each observer are be notified.
	 * 
	 * @param time The time at which the observer is notified.
	 * @param obs  The observer to notify.
	 */
	void addObserver(LocalTime time, IObsTimeLine obs);

	/**
	 * Remove the specified observer for the given time.
	 * 
	 * @param time The used as key to remove the observer.
	 * @param obs  The observer to remove.
	 */
	void removeObserver(LocalTime time, IObsTimeLine obs);

	/**
	 * Register periodically the given observer for the specific time. It is possible to add several periodic observers for the same
	 * time. It that case, each observer are be notified. When notified, those observers will be notified at the time equals
	 * currentTime + their period.
	 * 
	 * @param time The time at which the observer is notified.
	 * @param obs  The observer to notify.
	 */
	void addObserver(LocalTime time, ITimeLinePeriodicObserver obs);

	/**
	 * Remove the specified observer for the given time.
	 * 
	 * @param time The used as key to remove the observer.
	 * @param obs  The observer to remove.
	 */
	void removeObserver(ITimeLinePeriodicObserver obs);
}
