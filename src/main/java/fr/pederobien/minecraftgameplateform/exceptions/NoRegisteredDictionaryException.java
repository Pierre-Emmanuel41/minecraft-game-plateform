package fr.pederobien.minecraftgameplateform.exceptions;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class NoRegisteredDictionaryException extends AbstractDictionaryException {
	private static final long serialVersionUID = 1L;

	public NoRegisteredDictionaryException(IMessageEvent event) {
		super(event);
	}

	@Override
	public String getMessage() {
		return "No registered dictionary\n" + super.getMessage();
	}
}
