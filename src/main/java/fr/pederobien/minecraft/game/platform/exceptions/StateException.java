package fr.pederobien.minecraft.game.platform.exceptions;

public class StateException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	public StateException(Object state) {
		super("This method cannot be called by this state (" + state.getClass().getSimpleName() + ")");
	}
}
