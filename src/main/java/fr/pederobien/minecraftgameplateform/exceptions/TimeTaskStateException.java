package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

public class TimeTaskStateException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String message;

	public TimeTaskStateException(String message) {
		this.message = message;
	}

	@Override
	protected StringJoiner getInternalMessage(StringJoiner joiner) {
		return joiner.add(message);
	}
}
