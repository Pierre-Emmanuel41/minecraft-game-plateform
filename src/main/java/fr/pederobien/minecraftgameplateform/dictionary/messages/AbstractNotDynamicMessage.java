package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public class AbstractNotDynamicMessage extends AbstractMessage {
	private String message;

	public AbstractNotDynamicMessage(IMessageCode code, String message) {
		super(code);
		this.message = message;
	}

	@Override
	public String getMessage(String... args) {
		return message;
	}
}