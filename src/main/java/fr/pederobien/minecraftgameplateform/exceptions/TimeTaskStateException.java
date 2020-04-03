package fr.pederobien.minecraftgameplateform.exceptions;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;

public class TimeTaskStateException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	public TimeTaskStateException(ITimeTaskState state) {
		super("This method cannot be called by this state (" + state.getClass().getSimpleName() + ")");
	}
}
