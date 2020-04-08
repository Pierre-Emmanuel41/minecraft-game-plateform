package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_NameMustNotStartWithDefault extends AbstractMessage {
	/**
	 * Message in French explains the name must not start with "default"
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the name must not start with "default"
	 */
	public static final IMessage ENGLISH = new English();

	public Common_NameMustNotStartWithDefault() {
		super(ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends Common_NameMustNotStartWithDefault {
		@Override
		public String getMessage(String... args) {
			return args[0] + " ne doit pas commencer par 'default' (insensible à la casse)";
		}
	}

	private static class English extends Common_NameMustNotStartWithDefault {
		@Override
		public String getMessage(String... args) {
			return args[0] + " must not start with 'default' (ignoring case)";
		}
	}
}
