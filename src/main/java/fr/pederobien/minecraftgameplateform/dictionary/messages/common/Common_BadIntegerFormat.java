package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadIntegerFormat extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains the coordinates does not have the right format.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the coordinates does not have the right format.
	 */
	public static final IMessage ENGLISH = new English();

	public Common_BadIntegerFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT, message);
	}

	private static class French extends Common_BadIntegerFormat {
		public French() {
			super("Mauvais format, les arguments doivent être des entiers");
		}
	}

	private static class English extends Common_BadIntegerFormat {
		public English() {
			super("Bad format, arguments should be integer");
		}
	}
}
