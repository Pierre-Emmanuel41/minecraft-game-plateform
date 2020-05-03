package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonNew_TabComplete extends AbstractNotDynamicMessage {

	public CommonNew_TabComplete(String message) {
		super(ECommonMessageCode.COMMON_NEW__TAB_COMPLETE, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends CommonNew_TabComplete {
		public French() {
			super("<nom>");
		}
	}

	private static class English extends CommonNew_TabComplete {
		public English() {
			super("<name>");
		}
	}
}
