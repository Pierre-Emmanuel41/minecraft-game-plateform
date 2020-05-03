package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum ETeamModifyMessages {
	FRENCH, ENGLISH;

	private List<IMessage> messages;

	private ETeamModifyMessages() {
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
