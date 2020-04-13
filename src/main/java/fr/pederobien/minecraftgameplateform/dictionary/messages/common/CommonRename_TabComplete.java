package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonRename_TabComplete extends AbstractMessage {
	/**
	 * Message in French to get the new name of the current object.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to get the new name of the current object.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonRename_TabComplete() {
		super(ECommonMessageCode.COMMON_RENAME__TAB_COMPLETE);
	}

	private static class French extends CommonRename_TabComplete {
		@Override
		public String getMessage(String... args) {
			return "<nouveau nom>";
		}
	}

	private static class English extends CommonRename_TabComplete {
		@Override
		public String getMessage(String... args) {
			return "<new name>";
		}
	}
}
