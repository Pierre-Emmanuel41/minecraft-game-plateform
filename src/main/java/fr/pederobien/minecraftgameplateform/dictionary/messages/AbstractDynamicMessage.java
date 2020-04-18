package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public class AbstractDynamicMessage extends AbstractMessage {

	public AbstractDynamicMessage(IMessageCode code) {
		super(code);
	}

	@Override
	public String getMessage(String... args) {
		return "No message to return (maybe override the method getMessage)";
	}
}
