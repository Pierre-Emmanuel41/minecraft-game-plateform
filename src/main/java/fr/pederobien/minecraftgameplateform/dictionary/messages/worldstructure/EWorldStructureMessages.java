package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.IMessages;

public enum EWorldStructureMessages implements IMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;

	private EWorldStructureMessages() {
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
