package fr.pederobien.minecraftgameplateform.impl.runtime.timeline;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObsTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.IObservableTimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.ITimeLineObserver;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.ITimeLinePeriodicObserver;

public class TimeLine implements IObservableTimeLine, IObsTimeTask {
	private Map<LocalTime, IObservable<ITimeLineObserver>> punctual;
	private Map<LocalTime, IObservable<ITimeLinePeriodicObserver>> periodic;

	private TimeLine() {
		punctual = new HashMap<LocalTime, IObservable<ITimeLineObserver>>();
		periodic = new HashMap<LocalTime, IObservable<ITimeLinePeriodicObserver>>();
	}

	public static IObservableTimeLine getInstance() {
		return SingletonHolder.TIME_LINE;
	}

	private static class SingletonHolder {
		public static final TimeLine TIME_LINE = new TimeLine();
	}

	@Override
	public void timeChanged(ITimeTask task) {
		// Notify all punctual observers of the time = task.getIncreasingTime()
		notifyObservers(punctual, task.getGameTime(), obs -> obs.timeChanged(task.getGameTime()));

		// Notify all periodic observers of the time = task.getIncreasingTime()
		notifyObservers(periodic, task.getGameTime(), obs -> {
			obs.timeChanged(task.getGameTime());
			LocalTime nextNotifyTime = task.getGameTime().plusSeconds(obs.getPeriod().toSecondOfDay());
			obs.setNextNotifyTime(nextNotifyTime);

			// the current observer is notified for the time @var= nextNotifyTime
			addObserverToMap(periodic, nextNotifyTime, obs);
		});

		// Remove all observers for the key task.getIncreasingTime()
		periodic.remove(task.getGameTime());

		// Notify each observer no matter the time that the current time has changed.
		for (IObservable<ITimeLinePeriodicObserver> observable : periodic.values())
			observable.notifyObservers(obs -> obs.notifyCurrentTimeChanged());
	}

	@Override
	public void addObserver(LocalTime time, ITimeLineObserver obs) {
		addObserverToMap(punctual, time, obs);
	}

	@Override
	public void removeObserver(LocalTime time, ITimeLineObserver obs) {
		removeObserverToMap(punctual, time, obs);
	}

	@Override
	public void addObserver(LocalTime time, ITimeLinePeriodicObserver obs) {
		addObserverToMap(periodic, time, obs);
	}

	@Override
	public void removeObserver(ITimeLinePeriodicObserver obs) {
		removeObserverToMap(periodic, obs.getNextNotifyTime(), obs);
	}

	private <T extends ITimeLineObserver> void addObserverToMap(Map<LocalTime, IObservable<T>> observers, LocalTime time, T obs) {
		if (observers.containsKey(time))
			observers.get(time).addObserver(obs);
		else {
			IObservable<T> observable = new Observable<T>();
			observable.addObserver(obs);
			observers.put(time, observable);
		}
	}

	private <T extends ITimeLineObserver> void removeObserverToMap(Map<LocalTime, IObservable<T>> observers, LocalTime time, T obs) {
		observers.get(time).removeObserver(obs);
		if (observers.get(time).size() == 0)
			observers.remove(time);
	}

	private <T extends ITimeLineObserver> void notifyObservers(Map<LocalTime, IObservable<T>> observers, LocalTime time, Consumer<T> consumer) {
		IObservable<T> observable = observers.get(time);
		if (observable != null)
			observable.notifyObservers(consumer);
	}
}
