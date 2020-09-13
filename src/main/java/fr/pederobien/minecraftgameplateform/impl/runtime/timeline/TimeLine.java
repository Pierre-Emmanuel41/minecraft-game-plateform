package fr.pederobien.minecraftgameplateform.impl.runtime.timeline;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObsTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObsTimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObservableTimeLine;

public class TimeLine implements IObservableTimeLine, IObsTimeTask {
	private Map<LocalTime, IObservable<IObsTimeLine>> observers;
	private Map<LocalTime, IObservable<IObsTimeLine>> countdown;

	private TimeLine() {
		observers = new HashMap<LocalTime, IObservable<IObsTimeLine>>();
		countdown = new HashMap<LocalTime, IObservable<IObsTimeLine>>();
	}

	public static IObservableTimeLine getInstance() {
		return SingletonHolder.TIME_LINE;
	}

	private static class SingletonHolder {
		public static final TimeLine TIME_LINE = new TimeLine();
	}

	@Override
	public void onStart(ITimeTask task) {

	}

	@Override
	public void onPause(ITimeTask task) {

	}

	@Override
	public void onRelaunched(ITimeTask task) {

	}

	@Override
	public void onStop(ITimeTask task) {
		observers.clear();
		countdown.clear();
	}

	@Override
	public void timeChanged(ITimeTask task) {
		LocalTime currentTime = task.getGameTime();
		// Getting observers associated to the game time of the task.
		IObservable<IObsTimeLine> obsOnTime = observers.get(currentTime);

		// If there are observers interested by the current game time
		if (obsOnTime != null) {
			obsOnTime.getObservers().stream().forEach(obs -> {
				// Notify the observer using onTime
				obs.onTime(currentTime);

				LocalTime nextRelativeTime = obs.getNextNotifiedTime();

				// Check if the observer should be notified later.
				LocalTime nextAbsoluteNotifiedTime = currentTime.plusSeconds(nextRelativeTime.toSecondOfDay());
				if (!nextAbsoluteNotifiedTime.equals(LocalTime.of(0, 0, 0))) {
					IObservable<IObsTimeLine> nextObsList = observers.get(nextAbsoluteNotifiedTime);

					// If the observer is the first observer for the nextNotifiedTime then creating a new observers list.
					if (nextObsList == null) {
						nextObsList = new Observable<IObsTimeLine>();
						observers.put(nextAbsoluteNotifiedTime, nextObsList);
					}

					// Adding the observer to the list in order to be notified later.
					nextObsList.addObserver(obs);

					// Getting observers associated to the game time of the task.
					LocalTime countDownTime = currentTime.plusSeconds(nextRelativeTime.minusSeconds(obs.getCountDown()).toSecondOfDay());
					IObservable<IObsTimeLine> obsOnCountDownTime = countdown.get(countDownTime);
					if (obsOnCountDownTime == null) {
						obsOnCountDownTime = new Observable<IObsTimeLine>();
						countdown.put(countDownTime, obsOnCountDownTime);
					}
					obsOnCountDownTime.addObserver(obs);
				}
			});
		}

		// Getting observers associated to the game time of the task.
		IObservable<IObsTimeLine> obsOnCountDownTime = countdown.get(currentTime);
		if (obsOnCountDownTime != null) {
			obsOnCountDownTime.getObservers().stream().forEach(obs -> {
				// Notify the observer using onTime
				obs.onCountDownTime(currentTime);

				if (obs.getCurrentCountDown() != 0) {
					LocalTime nextNotifiedTime = currentTime.plusSeconds(1);
					IObservable<IObsTimeLine> nextObsList = countdown.get(nextNotifiedTime);

					// If the observer is the first observer for the nextNotifiedTime then creating a new observers list.
					if (nextObsList == null) {
						nextObsList = new Observable<IObsTimeLine>();
						countdown.put(nextNotifiedTime, nextObsList);
					}

					// Adding the observer to the list in order to be notified later.
					nextObsList.addObserver(obs);
				}
			});
		}
	}

	@Override
	public void addObserver(LocalTime time, IObsTimeLine obs) {
		// Getting observers associated to the game time of the task.
		IObservable<IObsTimeLine> obsOnTime = observers.get(time);

		// If there are observers interested by the current game time
		if (obsOnTime == null) {
			obsOnTime = new Observable<IObsTimeLine>();
			observers.put(time, obsOnTime);
		}
		obsOnTime.addObserver(obs);

		// Getting observers associated to the game time of the task.
		LocalTime countDownTime = time.minusSeconds(obs.getCountDown());
		IObservable<IObsTimeLine> obsOnCountDownTime = countdown.get(countDownTime);
		if (obsOnCountDownTime == null) {
			obsOnCountDownTime = new Observable<IObsTimeLine>();
			countdown.put(countDownTime, obsOnCountDownTime);
		}
		obsOnCountDownTime.addObserver(obs);
	}

	@Override
	public void removeObserver(LocalTime time, IObsTimeLine obs) {
		observers.remove(time);
		countdown.remove(time);
	}
}
