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
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		joiner.add("Not enough arguments");
		super.getInternalMessage(joiner);
		return joiner.add(getDictionary().toString());
	}
}
