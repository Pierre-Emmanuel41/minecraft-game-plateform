package fr.pederobien.minecraftgameplateform.impl.runtime.task;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.InitialTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.PauseTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.RunTimeTaskState;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public class TimeTask extends Observable<ITimeTaskObserver> implements IStateTimeTask, ITimeTask, IObservable<ITimeTaskObserver> {
	private ITimeTaskState current;
	private ITimeTaskState initial;
	private ITimeTaskState run;
	private ITimeTaskState pause;

	private BukkitTask task;

	private TimeTask() {
		initial = new InitialTimeTaskState(this);
		run = new RunTimeTaskState(this);
		pause = new PauseTimeTaskState(this);

		setCurrentState(initial);
	}

	public static ITimeTask getInstance() {
		return SingletonHolder.TASK;
	}

	private static class SingletonHolder {
		public static final ITimeTask TASK = new TimeTask();
	}

	@Override
	public void start(Plugin plugin) {
		current.start(plugin);
	}

	@Override
	public void pause() {
		current.pause();
	}

	@Override
	public void relaunched() {
		current.relaunched();
	}

	@Override
	public void stop() {
		current.stop();
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
		this.current = current;
		return current;
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
		notifyObservers(obs -> obs.timeChanged(this));
	}
}
