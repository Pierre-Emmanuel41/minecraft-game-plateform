package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NoConfigurationSetted extends AbstractNotDynamicMessage {
	/**
	 * Message in French when there is no game to launch.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when there is no game to launch.
	 */
	public static final IMessage ENGLISH = new English();

	public NoConfigurationSetted(String message) {
		super(EGameMessageCode.NO_CONFIGURATION_SETTED, message);
	}

	private static class French extends NoConfigurationSetted {
		public French() {
			super("Aucune partie selectionnée");
		}
	}

	private static class English extends NoConfigurationSetted {
		public English() {
			super("No game has been selected");
		}
	}
}
