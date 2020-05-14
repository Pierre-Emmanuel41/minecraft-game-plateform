package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_HelpExplanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_HelpExplanation(String message) {
		super(ECommonMessageCode.COMMON_HELP_EXPLANATION, message);
	}

	private static class French extends Common_HelpExplanation {
		public French() {
			super("Pour afficher toutes les fonctionnalités et leurs explications");
		}
	}

	private static class English extends Common_HelpExplanation {
		public English() {
			super("To display all features and their explanations");
		}
	}
}
