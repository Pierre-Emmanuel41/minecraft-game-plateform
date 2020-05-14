package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.impl.AbstractMinecraftMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public class AbstractNotDynamicMessage extends AbstractMinecraftMessage {
	private String message;

	public AbstractNotDynamicMessage(IMinecraftMessageCode code, String message) {
		super(code);
		this.message = message;
	}

	@Override
	public String getMessage(String... args) {
		return message;
	}
}
