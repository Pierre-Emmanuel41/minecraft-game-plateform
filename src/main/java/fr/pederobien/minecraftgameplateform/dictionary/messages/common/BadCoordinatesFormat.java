package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class BadCoordinatesFormat extends AbstractMessage {
	/**
	 * Message in French explains the coordinates does not have the right format.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates does not have the right format.
	 */
	public static final IMessage ENGLISH = new English();

	public BadCoordinatesFormat() {
		super(ECommonCode.COMMON_BAD_COORDINATES_FORMAT);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends BadCoordinatesFormat {
		@Override
		public String getMessage(String... args) {
			return "Mauvais format des coordonnées, elles doivent être des entiers";
		}
	}

	private static class English extends BadCoordinatesFormat {
		@Override
		public String getMessage(String... args) {
			return "Bad coordinates format, they should be integer";
		}
	}
}
