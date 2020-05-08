package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonRename_TabComplete extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CommonRename_TabComplete(String message) {
		super(ECommonMessageCode.COMMON_RENAME_TAB_COMPLETE, message);
	}

	private static class French extends CommonRename_TabComplete {
		public French() {
			super("<nouveau nom>");
		}
	}

	private static class English extends CommonRename_TabComplete {
		public English() {
			super("<new name>");
		}
	}
}
