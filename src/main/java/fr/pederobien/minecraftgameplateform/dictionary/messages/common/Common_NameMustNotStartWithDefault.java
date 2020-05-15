package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NameMustNotStartWithDefault extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_NameMustNotStartWithDefault() {
		super(ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT);
	}

	private static class French extends Common_NameMustNotStartWithDefault {
		@Override
		public String getMessage(Object... args) {
			return args[0] + " ne doit pas commencer par 'default' (insensible à la casse)";
		}
	}

	private static class English extends Common_NameMustNotStartWithDefault {
		@Override
		public String getMessage(Object... args) {
			return args[0] + " must not start with 'default' (ignoring case)";
		}
	}
}
