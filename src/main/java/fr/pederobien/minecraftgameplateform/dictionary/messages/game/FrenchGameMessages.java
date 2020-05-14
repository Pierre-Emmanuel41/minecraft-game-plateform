package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchGameMessages {
	STARTING_GAME(StartingGame.FRENCH),

	NO_CONFIGURATION_SETTED(NoConfigurationSetted.FRENCH),

	PAUSING_GAME(PausingGame.FRENCH),

	RESUMING_GAME(ResumingGame.FRENCH),

	STOPPING_GAME(StoppingGame.FRENCH);

	private IMinecraftMessage source;

	private FrenchGameMessages(IMinecraftMessage source) {
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
	public IMinecraftMessage getSource() {
		return source;
	}
}
