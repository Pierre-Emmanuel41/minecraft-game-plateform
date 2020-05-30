package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class RunTimeTaskState extends AbstractTimeTaskState {
	private LocalTime gameTime;

	public RunTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {
		setInternalTotalTime(getInternalTotalTime().plusSeconds(1));
		gameTime = gameTime.plusSeconds(1);
	}

	@Override
	public void pause() {
		getTask().setCurrentState(getTask().getPauseState());
	}

	@Override
	public void cancel() {
		gameTime = LocalTime.of(0, 0, 0);
	}

	@Override
	public LocalTime getTotalTime() {
		return getInternalTotalTime();
	}

	@Override
	public LocalTime getGameTime() {
		return gameTime;
	}

	@Override
	public LocalTime getPauseTime() {
		return getTask().getPauseState().getPauseTime();
	}
}
