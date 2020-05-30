package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.exceptions.TimeTaskStateException;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public abstract class AbstractTimeTaskState implements ITimeTaskState {
	private IStateTimeTask task;
	private LocalTime totalTime;

	protected AbstractTimeTaskState(IStateTimeTask task) {
		this.task = task;
	}

	@Override
	public void run() {
		throw new TimeTaskStateException(this);
	}

	@Override
	public void pause() {
		throw new TimeTaskStateException(this);
	}

	@Override
	public void relaunched() {
		throw new TimeTaskStateException(this);
	}

	@Override
	public void cancel() {
		throw new TimeTaskStateException(this);
	}

	protected IStateTimeTask getTask() {
		return task;
	}

	protected LocalTime getInternalTotalTime() {
		return totalTime;
	}

	protected void setInternalTotalTime(LocalTime totalTime) {
		this.totalTime = totalTime;
	}
}
