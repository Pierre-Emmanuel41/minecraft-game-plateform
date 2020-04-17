package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_MissingCoordinates extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains the coordinates are missing
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates are missing
	 */
	public static final IMessage ENGLISH = new English();

	public Common_MissingCoordinates(String message) {
		super(EWorldStructureMessageCode.COMMON_MISSING_COORDINATES, message);
	}

	private static class French extends Common_MissingCoordinates {
		public French() {
			super("Impossible de d�finir les coordonn�es, il manque <X> ou <Y> ou <Z>");
		}
	}

	private static class English extends Common_MissingCoordinates {
		public English(String... args) {
			super("Cannot define coordinates, <X> or <Y> or <Z> is missing");
		}
	}
}
