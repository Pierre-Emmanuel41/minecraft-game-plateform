package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class PausingGame extends AbstractMessage {
	/**
	 * Message in French when a game is pausing.
	 */
	public static final IMessage FRENCH = new French();

	/**
	 * Message in English when a game is pausing.
	 */
	public static final IMessage ENGLISH = new English();

	public PausingGame() {
		super(EGameMessageCode.PAUSING_GAME);
	}

	private static class French extends PausingGame {
		@Override
		public String getMessage(String... args) {
			return "Partie suspendue";
		}
	}

	private static class English extends PausingGame {
		@Override
		public String getMessage(String... args) {
			return "Game resumed";
		}
	}
}
