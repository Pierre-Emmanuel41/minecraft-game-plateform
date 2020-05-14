package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_RenameTabComplete extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_RenameTabComplete(String message) {
		super(ECommonMessageCode.COMMON_RENAME_TAB_COMPLETE, message);
	}

	private static class French extends Common_RenameTabComplete {
		public French() {
			super("<nouveau nom>");
		}
	}

	private static class English extends Common_RenameTabComplete {
		public English() {
			super("<new name>");
		}
	}
}
