package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonRename_TabComplete extends AbstractNotDynamicMessage {

	public CommonRename_TabComplete(String message) {
		super(ECommonMessageCode.COMMON_RENAME__TAB_COMPLETE, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
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
