package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ResumingGame extends AbstractNotDynamicMessage {
	/**
	 * Message in French when a game is resuming.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a game is resuming.
	 */
	public static final IMessage ENGLISH = new English();

	public ResumingGame(String message) {
		super(EGameMessageCode.RESUMING_GAME, message);
	}

	private static class French extends ResumingGame {
		public French(String... args) {
			super("Reprise de la partie");
		}
	}

	private static class English extends ResumingGame {
		public English(String... args) {
			super("Resume");
		}
	}
}
