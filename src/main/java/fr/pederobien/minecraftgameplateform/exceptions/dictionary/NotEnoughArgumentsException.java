package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class NotEnoughArgumentsException extends AbstractDictionaryMessageException {
	private static final long serialVersionUID = 1L;
	private IMessage message;

	public NotEnoughArgumentsException(IMessageEvent event, IDictionary dictionary, IMessage message) {
		super(event, dictionary);
		this.message = message;
	}

	/**
	 * @return The message found in the dictionary.
	 */
	public IMessage getDictionaryMessage() {
		return message;
	}

	@Override
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		joiner.add("Not enough arguments");
		super.getInternalMessage(joiner);
		joiner.add(getDictionary().toString());
		joiner.add("{Message=" + getDictionaryMessage() + "}");
		return joiner;
	}
}
