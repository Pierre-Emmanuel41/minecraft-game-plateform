package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadBooleanFormat extends AbstractNotDynamicMessage {

	public Common_BadBooleanFormat(String message) {
		super(ECommonMessageCode.COMMON__BAD_BOOLEAN_FORMAT, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends Common_BadBooleanFormat {
		public French() {
			super("Mauvais format, l'argument doit être un booleen (true/false)");
		}
	}

	private static class English extends Common_BadBooleanFormat {
		public English() {
			super("Bad format, the argument should be a boolean (true/false)");
		}
	}
}
