package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ResumingGame extends AbstractNotDynamicMessage {

	public ResumingGame(String message) {
		super(EGameMessageCode.RESUMING_GAME, message);
		EGameMessages.FRENCH.add(new French());
		EGameMessages.ENGLISH.add(new English());
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
