package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_MissingCoordinates extends AbstractNotDynamicMessage {

	public Common_MissingCoordinates(String message) {
		super(ECommonMessageCode.COMMON_MISSING_COORDINATES, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends Common_MissingCoordinates {
		public French() {
			super("Impossible de définir les coordonnées, il manque <X> ou <Y> ou <Z>");
		}
	}

	private static class English extends Common_MissingCoordinates {
		public English(String... args) {
			super("Cannot define coordinates, <X> or <Y> or <Z> is missing");
		}
	}
}
