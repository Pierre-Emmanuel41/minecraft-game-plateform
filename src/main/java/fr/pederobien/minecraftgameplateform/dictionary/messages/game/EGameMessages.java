package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EGameMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;

	private EGameMessages() {
		messages = new ArrayList<IMessage>();
	}

	public void add(IMessage message) {
		if (!messages.contains(message))
			messages.add(message);
	}

	public List<IMessage> getMessages() {
		return Collections.unmodifiableList(messages);
	}
}
