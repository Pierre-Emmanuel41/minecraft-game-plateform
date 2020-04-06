package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonCenterExplanation extends AbstractMessage {
	/**
	 * Message in French to explain what does the command "center" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to explain what does the command "center" do.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonCenterExplanation() {
		super(EWorldStructureMessageCode.COMMON_CENTER_EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends CommonCenterExplanation {
		@Override
		public String getMessage(String... args) {
			return "Pour définir le centre";
		}
	}

	private static class English extends CommonCenterExplanation {
		@Override
		public String getMessage(String... args) {
			return "To set the center";
		}
	}
}
