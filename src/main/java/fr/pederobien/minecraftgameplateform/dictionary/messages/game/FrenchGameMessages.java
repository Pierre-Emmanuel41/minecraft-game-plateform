package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchGameMessages {
	STARTING_GAME(StartingGame.FRENCH),

	NO_CONFIGURATION_SETTED(NoConfigurationSetted.FRENCH),

	PAUSING_GAME(PausingGame.FRENCH),

	RESUMING_GAME(ResumingGame.FRENCH),

	STOPPING_GAME(StoppingGame.FRENCH);

	private IMessage source;

	private FrenchGameMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchGameMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
