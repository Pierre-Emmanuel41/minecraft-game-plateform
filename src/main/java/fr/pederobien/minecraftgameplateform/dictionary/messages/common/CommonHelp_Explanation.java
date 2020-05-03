package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonHelp_Explanation extends AbstractNotDynamicMessage {

	public CommonHelp_Explanation(String message) {
		super(ECommonMessageCode.COMMON_HELP__EXPLANATION, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends CommonHelp_Explanation {
		public French() {
			super("Pour afficher toutes les fonctionnalités et leurs explications");
		}
	}

	private static class English extends CommonHelp_Explanation {
		public English() {
			super("To display all features and their explanations");
		}
	}
}
