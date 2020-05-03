package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NameMustNotStartWithDefault extends AbstractDynamicMessage {

	public Common_NameMustNotStartWithDefault() {
		super(ECommonMessageCode.COMMON_NAME_MUST_NOT_START_WITH_DEFAULT);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
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
