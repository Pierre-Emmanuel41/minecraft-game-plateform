package fr.pederobien.minecraftgameplateform.spawn.messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.element.IMessages;

public enum ESpawnMessages implements IMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;
	private IDictionary dictionary;

	private ESpawnMessages() {
		messages = new ArrayList<IMessage>();
	}

	@Override
	public void add(IMessage message) {
		if (messages.contains(message))
			return;

		messages.add(message);
		if (dictionary != null)
			dictionary.register(message);
	}

	@Override
	public List<IMessage> getMessages() {
		return Collections.unmodifiableList(messages);
	}

	@Override
	public void setDictionary(IDictionary dictionary) {
		this.dictionary = dictionary;
		for (IMessage message : messages)
			dictionary.register(message);
	}
}
