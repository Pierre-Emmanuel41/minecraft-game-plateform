package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class PausingGame extends AbstractNotDynamicMessage {
	/**
	 * Message in French when a game is pausing.
	 */
	public static final IMessage FRENCH = new French();

	/**
	 * Message in English when a game is pausing.
	 */
	public static final IMessage ENGLISH = new English();

	public PausingGame(String message) {
		super(EGameMessageCode.PAUSING_GAME, message);
	}

	private static class French extends PausingGame {
		public French() {
			super("Partie suspendue");
		}
	}

	private static class English extends PausingGame {
		public English() {
			super("Pause");
		}
	}
}
