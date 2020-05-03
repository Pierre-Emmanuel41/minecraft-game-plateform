package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadIntegerFormat extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_BadIntegerFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT, message);
	}

	private static class French extends Common_BadIntegerFormat {
		public French() {
			super("Mauvais format, les arguments doivent �tre des entiers");
		}
	}

	private static class English extends Common_BadIntegerFormat {
		public English() {
			super("Bad format, arguments should be integer");
		}
	}
}
