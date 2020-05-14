package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum EnglishGameMessages {
	STARTING_GAME(StartingGame.ENGLISH),

	NO_CONFIGURATION_SETTED(NoConfigurationSetted.ENGLISH),

	PAUSING_GAME(PausingGame.ENGLISH),

	RESUMING_GAME(ResumingGame.ENGLISH),

	STOPPING_GAME(StoppingGame.ENGLISH);

	private IMinecraftMessage source;

	private EnglishGameMessages(IMinecraftMessage source) {
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
	public IMinecraftMessage getSource() {
		return source;
	}
}
