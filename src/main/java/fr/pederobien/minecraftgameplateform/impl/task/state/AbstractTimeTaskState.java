package fr.pederobien.minecraftgameplateform.impl.task.state;

import fr.pederobien.minecraftgameplateform.exceptions.TimeTaskStateException;
import fr.pederobien.minecraftgameplateform.interfaces.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.task.state.ITimeTaskState;

public abstract class AbstractTimeTaskState implements ITimeTaskState {
	private IStateTimeTask task;

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

	private String getExceptionMessage() {
		return "This method cannot be called by this state (" + getClass().getSimpleName() + ")";
	}
}
