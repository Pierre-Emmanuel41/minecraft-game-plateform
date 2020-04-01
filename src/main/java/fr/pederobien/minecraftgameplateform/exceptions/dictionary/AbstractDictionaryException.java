package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.exceptions.MinecraftPlateformException;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public abstract class AbstractDictionaryException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private IMessageEvent event;

	protected AbstractDictionaryException(IMessageEvent event) {
		this.event = event;
	}

	/**
	 * @return An array of arguments used for the not returned message.
	 */
	public IMessageEvent getEvent() {
		return event;
	}

	@Override
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		joiner.add("{Plugin=" + getEvent().getPlugin().getName() + "}");
		joiner.add("{Code=" + getEvent().getCode() + "}");
		joiner.add("{Args={");
		StringJoiner joinerBis = new StringJoiner(" ");
		for (String arg : getEvent().getArgs())
			joinerBis.add(arg);
		joinerBis.add("}");
		return joiner.add(joinerBis.toString());
	}
}
