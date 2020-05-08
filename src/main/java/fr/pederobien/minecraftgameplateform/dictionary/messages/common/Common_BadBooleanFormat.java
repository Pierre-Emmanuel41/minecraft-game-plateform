package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadBooleanFormat extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_BadBooleanFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_BOOLEAN_FORMAT, message);
	}

	private static class French extends Common_BadBooleanFormat {
		public French() {
			super("Mauvais format, l'argument doit �tre un booleen (true/false)");
		}
	}

	private static class English extends Common_BadBooleanFormat {
		public English() {
			super("Bad format, the argument should be a boolean (true/false)");
		}
	}
}
