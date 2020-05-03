package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.element.IMessages;

public enum ECommonMessages implements IMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;

	private ECommonMessages() {
		messages = new ArrayList<IMessage>();
	}

	@Override
	public void add(IMessage message) {
		if (!messages.contains(message))
			messages.add(message);
	}

	@Override
	public List<IMessage> getMessages() {
		return Collections.unmodifiableList(messages);
	}
}
