package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class HelpExplanation extends AbstractNotDynamicMessage {

	public HelpExplanation(String message) {
		super(ECommonMessageCode.COMMON_HELP__EXPLANATION, message);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends HelpExplanation {
		public French() {
			super("Pour afficher toutes les fonctionnalités et leurs explications");
		}
	}

	private static class English extends HelpExplanation {
		public English() {
			super("To display all features and their explanations");
		}
	}
}
