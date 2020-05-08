package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_MissingCoordinates extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_MissingCoordinates(String message) {
		super(ECommonMessageCode.COMMON_MISSING_COORDINATES, message);
	}

	private static class French extends Common_MissingCoordinates {
		public French() {
			super("Impossible de définir les coordonnées, il manque une ou plusieurs coordonnées");
		}
	}

	private static class English extends Common_MissingCoordinates {
		public English(String... args) {
			super("Cannot define coordinates, one or more coordinates are missing");
		}
	}
}
