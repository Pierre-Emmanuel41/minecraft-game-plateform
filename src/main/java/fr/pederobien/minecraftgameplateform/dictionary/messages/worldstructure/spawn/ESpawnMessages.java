package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum ESpawnMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;

	private ESpawnMessages() {
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
