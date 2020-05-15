package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_MissingCoordinates extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_MissingCoordinates(String message) {
		super(ECommonMessageCode.COMMON_MISSING_COORDINATES, message);
	}

	private static class French extends Common_MissingCoordinates {
		public French() {
			super("Impossible de définir les coordonnées, il manque une ou plusieurs coordonnées");
		}
	}

	private static class English extends Common_MissingCoordinates {
		public English() {
			super("Cannot define coordinates, one or more coordinates are missing");
		}
	}
}
