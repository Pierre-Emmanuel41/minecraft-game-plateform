package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class MessageNotFoundException extends AbstractDictionaryMessageException {
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(IMessageEvent event, IDictionary dictionary) {
		super(event, dictionary);
	}

	@Override
	public String getMessage() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("No associated message");
		joiner.add(super.getMessage());
		return joiner.add(getDictionary().toString()).toString();
	}
}
