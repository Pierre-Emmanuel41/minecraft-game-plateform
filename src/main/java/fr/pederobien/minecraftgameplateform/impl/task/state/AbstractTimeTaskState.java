package fr.pederobien.minecraftgameplateform.impl.task.state;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.exceptions.TimeTaskStateException;
import fr.pederobien.minecraftgameplateform.interfaces.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.task.state.ITimeTaskState;

public abstract class AbstractTimeTaskState implements ITimeTaskState {
	private IStateTimeTask task;
	private LocalTime totalTime, limitTime;

	protected AbstractTimeTaskState(IStateTimeTask task) {
		this.task = task;
	}

	@Override
	public void run() {
		throw new TimeTaskStateException(getExceptionMessage());
	}

	@Override
	public void pause() {
		throw new TimeTaskStateException(getExceptionMessage());
	}

	@Override
	public void relaunched() {
		throw new TimeTaskStateException(getExceptionMessage());
	}

	@Override
	public void cancel() {
		throw new TimeTaskStateException(getExceptionMessage());
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

	protected LocalTime getLimitTime() {
		return limitTime;
	}

	protected void setLimiteTime(LocalTime limitTime) {
		this.limitTime = limitTime;
	}

	private String getExceptionMessage() {
		return "This method cannot be called by this state (" + getClass().getSimpleName() + ")";
	}
}
