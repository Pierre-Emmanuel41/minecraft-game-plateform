package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class InitialTimeTaskState extends AbstractTimeTaskState {

	public InitialTimeTaskState(IStateTimeTask task, LocalTime limitTime) {
		super(task);
		setLimiteTime(limitTime);
	}

	@Override
	public void run() {
		setInternalTotalTime(LocalTime.of(0, 0, 0));
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
