package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class MissingCoordinates extends AbstractMessage {
	/**
	 * Message in French explains the coordinates are missing
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates are missing
	 */
	public static final IMessage ENGLISH = new English();

	public MissingCoordinates() {
		super(ECommonCode.COMMON_MISSING_COORDINATES);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends MissingCoordinates {
		@Override
		public String getMessage(String... args) {
			return super.getMessage(args);
		}
	}

	private static class English extends MissingCoordinates {
		@Override
		public String getMessage(String... args) {
			return super.getMessage(args);
		}
	}
}
