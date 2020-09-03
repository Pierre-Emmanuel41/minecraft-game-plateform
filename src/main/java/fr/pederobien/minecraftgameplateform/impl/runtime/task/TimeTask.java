package fr.pederobien.minecraftgameplateform.impl.runtime.task;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.InitialTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.PauseTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.RunTimeTaskState;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObsTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public class TimeTask implements IStateTimeTask, ITimeTask {
	private ITimeTaskState current;
	private ITimeTaskState initial;
	private ITimeTaskState run;
	private ITimeTaskState pause;

	private BukkitTask task;
	private IObservable<IObsTimeTask> observable;

	private TimeTask() {
		initial = new InitialTimeTaskState(this);
		run = new RunTimeTaskState(this);
		pause = new PauseTimeTaskState(this);
		setCurrentState(initial);

		observable = new Observable<IObsTimeTask>();
	}

	public static ITimeTask getInstance() {
		return SingletonHolder.TASK;
	}

	private static class SingletonHolder {
		public static final ITimeTask TASK = new TimeTask();
	}

	@Override
	public void start(Plugin plugin) {
		observable.notifyObservers(obs -> obs.onStart(this));
		current.start(plugin);
	}

	@Override
	public void pause() {
		observable.notifyObservers(obs -> obs.onPause(this));
		current.pause();
	}

	@Override
	public void relaunched() {
		observable.notifyObservers(obs -> obs.onRelaunched(this));
		current.relaunched();
	}

	@Override
	public void stop() {
		observable.notifyObservers(obs -> obs.onStop(this));
		current.stop();
	}

	@Override
	public void run() {
		current.run();
	}

	@Override
	public void addObserver(IObsTimeTask obs) {
		observable.addObserver(obs);
	}

	@Override
	public void removeObserver(IObsTimeTask obs) {
		observable.removeObserver(obs);
	}

	@Override
	public LocalTime getTotalTime() {
		return current.getTotalTime();
	}

	@Override
	public LocalTime getGameTime() {
		return current.getGameTime();
	}

	@Override
	public LocalTime getPauseTime() {
		return current.getPauseTime();
	}

	@Override
	public ITimeTaskState getCurrentState() {
		return current;
	}

	@Override
	public ITimeTaskState setCurrentState(ITimeTaskState current) {
		return this.current = current;
	}

	@Override
	public ITimeTaskState getPauseState() {
		return pause;
	}

	@Override
	public ITimeTaskState getRunState() {
		return run;
	}

	@Override
	public ITimeTaskState getInitialState() {
		return initial;
	}

	@Override
	public BukkitTask getBukkitTask() {
		return task;
	}

	@Override
	public void setBukkitTask(BukkitTask task) {
		this.task = task;
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers(obs -> obs.timeChanged(this));
	}
}
