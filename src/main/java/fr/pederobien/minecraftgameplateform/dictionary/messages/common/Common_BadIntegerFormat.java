package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadIntegerFormat extends AbstractNotDynamicMessage {

	public Common_BadIntegerFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
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
