package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

public class InternalBadException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String exceptionClassName;

	public InternalBadException(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}

	@Override
	protected StringJoiner getInternalMessage(StringJoiner joiner) {
		StringJoiner internalJoiner = new StringJoiner(" ");
		internalJoiner.add("The joiner returned by class :");
		internalJoiner.add(exceptionClassName);
		internalJoiner.add("is not the given joiner");
		return joiner.add(internalJoiner.toString());
	}
}
