package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class StoppingGame extends AbstractNotDynamicMessage {

	public StoppingGame(String message) {
		super(EGameMessageCode.STOPPING_GAME, message);
		EGameMessages.FRENCH.add(new French());
		EGameMessages.ENGLISH.add(new English());
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
