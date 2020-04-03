package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

public class SimpleMessageException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String message;

	protected SimpleMessageException(String message) {
		this.message = message;
	}

	@Override
	protected StringJoiner getInternalMessage(StringJoiner joiner) {
		return joiner.add(message);
	}
}
