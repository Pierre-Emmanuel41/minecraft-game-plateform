package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public abstract class AbstractMessage implements IMessage {
	private IMessageCode code;

	public AbstractMessage(IMessageCode code) {
		this.code = code;
	}

	@Override
	public IMessageCode getCode() {
		return code;
	}
}
