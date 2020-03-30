package fr.pederobien.minecraftgameplateform.impl.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.task.state.IStateTimeTask;

public class PauseTimeTaskState extends AbstractTimeTaskState {
	private LocalTime pauseTime;

	public PauseTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {

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
