package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class InitialTimeTaskState extends AbstractTimeTaskState {

	public InitialTimeTaskState(IStateTimeTask task) {
		super(task);
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
	public LocalTime getGameTime() {
		return getTask().getCurrentState().getGameTime();
	}

	@Override
	public LocalTime getPauseTime() {
		return getTask().getCurrentState().getPauseTime();
	}
}
