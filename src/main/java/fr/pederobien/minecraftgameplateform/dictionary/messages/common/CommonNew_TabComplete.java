package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonNew_TabComplete extends AbstractMessage {
	/**
	 * Message in French to get the name of the future object to create.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to get the name of the future object to create.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonNew_TabComplete() {
		super(ECommonMessageCode.COMMON_NEW__TAB_COMPLETE);
	}

	private static class French extends CommonNew_TabComplete {
		@Override
		public String getMessage(String... args) {
			return "<nom>";
		}
	}

	private static class English extends CommonNew_TabComplete {
		@Override
		public String getMessage(String... args) {
			return "<name>";
		}
	}

}
