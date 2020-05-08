package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonHelp_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CommonHelp_Explanation(String message) {
		super(ECommonMessageCode.COMMON_HELP_EXPLANATION, message);
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
