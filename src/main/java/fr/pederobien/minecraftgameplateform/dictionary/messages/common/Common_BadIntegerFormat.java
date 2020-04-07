package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_BadIntegerFormat extends AbstractMessage {
	/**
	 * Message in French explains the coordinates does not have the right format.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates does not have the right format.
	 */
	public static final IMessage ENGLISH = new English();

	public Common_BadIntegerFormat() {
		super(ECommonCode.COMMON_BAD_INTEGER_FORMAT);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends Common_BadIntegerFormat {
		@Override
		public String getMessage(String... args) {
			return "Mauvais format, les arguments doivent être des entiers";
		}
	}

	private static class English extends Common_BadIntegerFormat {
		@Override
		public String getMessage(String... args) {
			return "Bad format, arguments should be integer";
		}
	}
}
