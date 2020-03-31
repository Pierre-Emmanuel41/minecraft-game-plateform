package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public abstract class AbstractDictionaryException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private IDictionary dictionary;
	private IMessageEvent event;

	protected AbstractDictionaryException(IDictionary dictionary, IMessageEvent event) {
		this.dictionary = dictionary;
		this.event = event;
	}

	/**
	 * @return The dictionary in which the messages should be stored.
	 */
	public IDictionary getDictionary() {
		return dictionary;
	}

	/**
	 * @return An array of arguments used for the not returned message.
	 */
	public IMessageEvent getEvent() {
		return event;
	}

	@Override
	public String getMessage() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("{Plugin=" + getEvent().getPlugin().getName() + "}");
		joiner.add(getDictionary().toString());
		joiner.add("{Code=" + getEvent().getCode() + "}");
		joiner.add("{Args={");
		StringJoiner joinerBis = new StringJoiner(" ");
		for (String arg : getEvent().getArgs())
			joinerBis.add(arg);
		joinerBis.add("}");
		return joiner.add(joinerBis.toString()).toString();
	}
}
