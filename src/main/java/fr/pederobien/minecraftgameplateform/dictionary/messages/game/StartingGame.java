package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class StartingGame extends AbstractDynamicMessage {

	protected StartingGame() {
		super(EGameMessageCode.STARTING_GAME);
		EGameMessages.FRENCH.add(new French());
		EGameMessages.ENGLISH.add(new English());
	}

	private static class French extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Lancement de " + args[0];
		}
	}

	private static class English extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Starting " + args[0];
		}
	}
}
