package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ResumingGame extends AbstractMessage {
	/**
	 * Message in French when a game is resuming.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a game is resuming.
	 */
	public static final IMessage ENGLISH = new English();

	public ResumingGame() {
		super(EGameMessageCode.RESUMING_GAME);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends ResumingGame {
		@Override
		public String getMessage(String... args) {
			return "Reprise de la partie";
		}
	}

	private static class English extends ResumingGame {
		@Override
		public String getMessage(String... args) {
			return "Resuming game";
		}
	}
}
