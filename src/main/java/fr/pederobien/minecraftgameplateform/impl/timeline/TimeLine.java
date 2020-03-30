package fr.pederobien.minecraftgameplateform.impl.timeline;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import fr.pederobien.minecraftgameplateform.interfaces.task.IObservableTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.interfaces.timeline.IObservableTimeLine;
import fr.pederobien.minecraftgameplateform.interfaces.timeline.ITimeLineObserver;
import fr.pederobien.minecraftgameplateform.interfaces.timeline.ITimeLinePeriodicObserver;

public class TimeLine implements IObservableTimeLine, ITimeTaskObserver {
	private Map<LocalTime, List<ITimeLineObserver>> punctualObservers;
	private Map<LocalTime, List<ITimeLinePeriodicObserver>> periodicObservers;

	public TimeLine(IObservableTimeTask task) {
		punctualObservers = new HashMap<LocalTime, List<ITimeLineObserver>>();
		periodicObservers = new HashMap<LocalTime, List<ITimeLinePeriodicObserver>>();

		task.addObserver(this);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		// Notify all punctual observers of the time = task.getIncreasingTime()
		notifyObservers(punctualObservers, task.getIncreasingTime(), obs -> obs.timeChanged(task.getIncreasingTime()));

		// Notify all periodic observers of the time = task.getIncreasingTime()
		notifyObservers(periodicObservers, task.getIncreasingTime(), obs -> {
			obs.timeChanged(task.getIncreasingTime());
			LocalTime nextNotifyTime = task.getIncreasingTime().plusSeconds(obs.getPeriod().toSecondOfDay());
			obs.setNextNotifyTime(nextNotifyTime);

			// the current observer is notified for the time @var= nextNotifyTime
			addObserverToMap(periodicObservers, nextNotifyTime, obs);
		});

		// Remove all observers for the key task.getIncreasingTime()
		periodicObservers.remove(task.getIncreasingTime());

		// Notify each observer no matter the time that the current time has changed.
		for (List<ITimeLinePeriodicObserver> list : periodicObservers.values())
			for (ITimeLinePeriodicObserver obs : list)
				obs.notifyCurrentTimeChanged();
	}

	@Override
	public void addObserver(LocalTime time, ITimeLineObserver obs) {
		addObserverToMap(punctualObservers, time, obs);
	}

	@Override
	public void removeObserver(LocalTime time, ITimeLineObserver obs) {
		removeObserverToMap(punctualObservers, time, obs);
	}

	@Override
	public void addObserver(LocalTime time, ITimeLinePeriodicObserver obs) {
		addObserverToMap(periodicObservers, time, obs);
	}

	@Override
	public void removeObserver(ITimeLinePeriodicObserver obs) {
		removeObserverToMap(periodicObservers, obs.getNextNotifyTime(), obs);
	}

	private <T extends ITimeLineObserver> void addObserverToMap(Map<LocalTime, List<T>> observers, LocalTime time, T obs) {
		if (observers.containsKey(time))
			observers.get(time).add(obs);
		else {
			List<T> list = new ArrayList<T>();
			list.add(obs);
			observers.put(time, list);
		}
	}

	private <T extends ITimeLineObserver> void removeObserverToMap(Map<LocalTime, List<T>> observers, LocalTime time, T obs) {
		observers.get(time).remove(obs);
		if (observers.get(time).size() == 0)
			observers.remove(time);
	}

	private <T extends ITimeLineObserver> void notifyObservers(Map<LocalTime, List<T>> observers, LocalTime time, Consumer<T> consumer) {
		List<T> list = observers.get(time);
		if (list != null)
			for (T obs : list)
				consumer.accept(obs);
	}
}
