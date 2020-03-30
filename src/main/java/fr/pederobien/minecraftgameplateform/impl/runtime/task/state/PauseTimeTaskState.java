package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class PauseTimeTaskState extends AbstractTimeTaskState {
	private LocalTime pauseTime;

	public PauseTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {
		setInternalTotalTime(getInternalTotalTime().plusSeconds(1));
		pauseTime = pauseTime.plusSeconds(1);
	}

	@Override
	public void relaunched() {
		getTask().setCurrentState(getTask().getRunState());
	}

	@Override
	public void cancel() {
		pauseTime = LocalTime.of(0, 0, 0);
	}

	@Override
	public LocalTime getTotalTime() {
		return getInternalTotalTime();
	}

	@Override
	public LocalTime getIncreasingTime() {
		return getTask().getRunState().getIncreasingTime();
	}

	@Override
	public LocalTime getDecreasingTime() {
		return getTask().getRunState().getDecreasingTime();
	}

	@Override
	public LocalTime getPauseTime() {
		return pauseTime;
	}
}
