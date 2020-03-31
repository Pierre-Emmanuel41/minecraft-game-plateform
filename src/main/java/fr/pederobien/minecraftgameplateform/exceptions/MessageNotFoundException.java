package fr.pederobien.minecraftgameplateform.exceptions;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class MessageNotFoundException extends AbstractDictionaryException {
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(IDictionary dictionary, IMessageEvent event) {
		super(dictionary, event);
	}

	@Override
	public String getMessage() {
		return "No associated message\n" + super.getMessage();
	}
}
