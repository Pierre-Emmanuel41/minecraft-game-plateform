package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftgameplateform.dictionary.EMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class HelpExplanation extends AbstractMessage {
	/**
	 * Message in French to explain what does the command "help" do.
	 */
	public static final IMessage FRENCH = new French();

	/**
	 * Message in English to explain what does the command "help" do.
	 */
	public static final IMessage ENGLISH = new English();

	public HelpExplanation() {
		super(EMessageCode.HELP_EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends HelpExplanation {

		@Override
		public String getMessage(String... args) {
			return "Pour afficher toutes les fonctionnalités et leurs explications";
		}
	}

	private static class English extends HelpExplanation {

		@Override
		public String getMessage(String... args) {
			return "To display all features and their explanations";
		}
	}
}
