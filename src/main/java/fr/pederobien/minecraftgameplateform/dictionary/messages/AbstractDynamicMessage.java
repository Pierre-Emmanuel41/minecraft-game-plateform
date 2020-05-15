package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.impl.AbstractMinecraftMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public class AbstractDynamicMessage extends AbstractMinecraftMessage {

	public AbstractDynamicMessage(IMinecraftMessageCode code) {
		super(code);
	}

	@Override
	public String getMessage(Object... args) {
		return "No message to return (maybe override the method getMessage)";
	}
}
