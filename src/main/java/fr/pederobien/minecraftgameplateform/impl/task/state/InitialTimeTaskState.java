package fr.pederobien.minecraftgameplateform.impl.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.task.state.IStateTimeTask;

public class InitialTimeTaskState extends AbstractTimeTaskState {

	public InitialTimeTaskState(IStateTimeTask task, LocalTime limitTime) {
		super(task);
		setLimiteTime(limitTime);
	}

	@Override
	public void run() {
		getTask().setCurrentState(getTask().getRunState());
	}

	@Override
	public LocalTime getTotalTime() {
		return getTask().getCurrentState().getTotalTime();
	}

	@Override
	public LocalTime getIncreasingTime() {
		return getTask().getCurrentState().getIncreasingTime();
	}

	@Override
	public LocalTime getDecreasingTime() {
		return getTask().getCurrentState().getDecreasingTime();
	}

	@Override
	public LocalTime getPauseTime() {
		return getTask().getCurrentState().getPauseTime();
	}
}
