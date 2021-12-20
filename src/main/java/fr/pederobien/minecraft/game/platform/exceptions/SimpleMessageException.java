package fr.pederobien.minecraft.game.platform.exceptions;

public class SimpleMessageException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String message;

	protected SimpleMessageException(String message) {
		this.message = message;
	}

	@Override
	protected String getInternalMessage() {
		return message;
	}
}
