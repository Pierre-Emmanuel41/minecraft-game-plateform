package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class StoppingGame extends AbstractMessage {
	/**
	 * Message in French when a game is stopping.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a game is stopping.
	 */
	public static final IMessage ENGLISH = new English();

	public StoppingGame() {
		super(EGameMessageCode.STOPPING_GAME);
	}

	private static class French extends StoppingGame {
		@Override
		public String getMessage(String... args) {
			return "Arrêt de la partie";
		}
	}

	private static class English extends StoppingGame {
		@Override
		public String getMessage(String... args) {
			return "Stopping game";
		}
	}
}
