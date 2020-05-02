package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class HelpExplanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French to explain what does the command "help" do.
	 */
	public static final IMessage FRENCH = new French();

	/**
	 * Message in English to explain what does the command "help" do.
	 */
	public static final IMessage ENGLISH = new English();

	public HelpExplanation(String message) {
		super(EMessageCode.HELP_EXPLANATION, message);
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
