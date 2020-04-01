package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class NoRegisteredDictionaryException extends AbstractDictionaryException {
	private static final long serialVersionUID = 1L;

	public NoRegisteredDictionaryException(IMessageEvent event) {
		super(event);
	}

	@Override
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		joiner.add("No registered dictionary");
		return super.getInternalMessage(joiner);
	}
}
