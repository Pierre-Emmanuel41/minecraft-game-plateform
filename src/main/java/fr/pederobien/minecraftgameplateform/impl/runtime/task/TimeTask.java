package fr.pederobien.minecraftgameplateform.impl.runtime.task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.InitialTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.PauseTimeTaskState;
import fr.pederobien.minecraftgameplateform.impl.runtime.task.state.RunTimeTaskState;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObservableTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public class TimeTask implements IStateTimeTask, ITimeTask, IObservableTimeTask {
	private ITimeTaskState current;
	private ITimeTaskState initial;
	private ITimeTaskState run;
	private ITimeTaskState pause;

	private List<ITimeTaskObserver> observers;

	public TimeTask(LocalTime time) {
		observers = new ArrayList<ITimeTaskObserver>();

		initial = new InitialTimeTaskState(this, time);
		run = new RunTimeTaskState(this);
		pause = new PauseTimeTaskState(this);

		setCurrentState(initial);
	}

	@Override
	public void run() {
		current.run();
		notifyObservers();
	}

	@Override
	public void addObserver(ITimeTaskObserver obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(ITimeTaskObserver obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (ITimeTaskObserver obs : observers)
			obs.timeChanged(this);
	}

	@Override
	public void cancel() {
		run.cancel();
		pause.cancel();
		setCurrentState(initial);
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
	public LocalTime getTotalTime() {
		return current.getTotalTime();
	}

	@Override
	public LocalTime getIncreasingTime() {
		return current.getIncreasingTime();
	}

	@Override
	public LocalTime getDecreasingTime() {
		return current.getDecreasingTime();
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
}