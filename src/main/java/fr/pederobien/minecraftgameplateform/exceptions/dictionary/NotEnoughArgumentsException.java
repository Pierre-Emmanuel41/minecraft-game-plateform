package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class NotEnoughArgumentsException extends AbstractDictionaryMessageException {
	private static final long serialVersionUID = 1L;

	public NotEnoughArgumentsException(IMessageEvent event, IDictionary dictionary) {
		super(event, dictionary);
	}

	@Override
	public String getMessage() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("Not enough arguments");
		joiner.add(super.getMessage());
		return joiner.add(getDictionary().toString()).toString();
	}
}
