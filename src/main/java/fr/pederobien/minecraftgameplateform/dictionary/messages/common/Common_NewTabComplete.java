package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_NewTabComplete extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_NewTabComplete(String message) {
		super(ECommonMessageCode.COMMON_NEW_TAB_COMPLETE, message);
	}

	private static class French extends Common_NewTabComplete {
		public French() {
			super("<nom>");
		}
	}

	private static class English extends Common_NewTabComplete {
		public English() {
			super("<name>");
		}
	}
}
