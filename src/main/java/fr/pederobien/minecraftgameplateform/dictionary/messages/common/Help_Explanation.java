package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Help_Explanation extends AbstractNotDynamicMessage {

	public Help_Explanation(String message) {
		super(ECommonMessageCode.COMMON_HELP__EXPLANATION, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends Help_Explanation {
		public French() {
			super("Pour afficher toutes les fonctionnalités et leurs explications");
		}
	}

	private static class English extends Help_Explanation {
		public English() {
			super("To display all features and their explanations");
		}
	}
}
