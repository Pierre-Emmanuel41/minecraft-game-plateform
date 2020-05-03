package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonNew_TabComplete extends AbstractNotDynamicMessage {
	/**
	 * Message in English to get the name of the future object to create.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonNew_TabComplete(String message) {
		super(ECommonMessageCode.COMMON_NEW__TAB_COMPLETE, message);
		ECommonMessages.FRENCH.add(new French());
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
