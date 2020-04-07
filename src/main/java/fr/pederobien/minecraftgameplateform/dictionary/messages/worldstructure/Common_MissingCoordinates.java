package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_MissingCoordinates extends AbstractMessage {
	/**
	 * Message in French explains the coordinates are missing
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates are missing
	 */
	public static final IMessage ENGLISH = new English();

	public Common_MissingCoordinates() {
		super(EWorldStructureMessageCode.COMMON_MISSING_COORDINATES);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends Common_MissingCoordinates {
		@Override
		public String getMessage(String... args) {
			return "Impossible de définir les coordonnées, il manque <X> ou <Y> ou <Z>";
		}
	}

	private static class English extends Common_MissingCoordinates {
		@Override
		public String getMessage(String... args) {
			return "Cannot define coordinates, <X> or <Y> or <Z> is missing";
		}
	}
}
