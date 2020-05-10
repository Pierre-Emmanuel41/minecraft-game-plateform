package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_TimeTabComplete extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_TimeTabComplete(String message) {
		super(ECommonMessageCode.COMMON_TIME_TAB_COMPLETE, message);
	}

	private static class French extends Common_TimeTabComplete {
		public French() {
			super("<hh:mm:ss>");
		}
	}

	private static class English extends Common_TimeTabComplete {
		public English() {
			super("<hh:mm:ss>");
		}
	}
}