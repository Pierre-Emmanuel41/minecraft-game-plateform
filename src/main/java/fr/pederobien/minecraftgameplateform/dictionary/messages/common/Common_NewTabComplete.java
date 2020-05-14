package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_NewTabComplete extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
