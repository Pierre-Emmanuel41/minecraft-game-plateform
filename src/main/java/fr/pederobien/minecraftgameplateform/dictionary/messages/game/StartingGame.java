package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class StartingGame extends AbstractMessage {
	/**
	 * Message in French when a game is starting.
	 */
	public static final IMessage FRENCH = new French();

	/**
	 * Message in English when a game is starting.
	 */
	public static final IMessage ENGLISH = new English();

	protected StartingGame() {
		super(EGameMessageCode.STARTING_GAME);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Lancement de la partie : " + args[0];
		}
	}

	private static class English extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Starting game : " + args[0];
		}
	}
}
