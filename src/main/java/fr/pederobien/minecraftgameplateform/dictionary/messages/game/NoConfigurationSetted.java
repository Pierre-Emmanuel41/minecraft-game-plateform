package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NoConfigurationSetted extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NoConfigurationSetted(String message) {
		super(EGameMessageCode.NO_CONFIGURATION_SETTED, message);
	}

	private static class French extends NoConfigurationSetted {
		public French() {
			super("Aucune partie selectionn�e");
		}
	}

	private static class English extends NoConfigurationSetted {
		public English() {
			super("No game has been selected");
		}
	}
}
