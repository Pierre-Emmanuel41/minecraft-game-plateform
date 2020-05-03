package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NoConfigurationSetted extends AbstractNotDynamicMessage {

	public NoConfigurationSetted(String message) {
		super(EGameMessageCode.NO_CONFIGURATION_SETTED, message);
		EGameMessages.FRENCH.add(new French());
		EGameMessages.ENGLISH.add(new English());
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
