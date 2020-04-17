package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class StoppingGame extends AbstractNotDynamicMessage {
	/**
	 * Message in French when a game is stopping.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a game is stopping.
	 */
	public static final IMessage ENGLISH = new English();

	public StoppingGame(String message) {
		super(EGameMessageCode.STOPPING_GAME, message);
	}

	private static class French extends StoppingGame {
		public French() {
			super("Arrêt de la partie");
		}
	}

	private static class English extends StoppingGame {
		public English() {
			super("Stopping game");
		}
	}
}
