package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishGameMessages {
	STARTING_GAME(StartingGame.ENGLISH),

	NO_CONFIGURATION_SETTED(NoConfigurationSetted.ENGLISH),

	PAUSING_GAME(PausingGame.ENGLISH),

	RESUMING_GAME(ResumingGame.ENGLISH),

	STOPPING_GAME(StoppingGame.ENGLISH);

	private IMessage source;

	private EnglishGameMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishGameMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
