package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class PausingGame extends AbstractNotDynamicMessage {

	public PausingGame(String message) {
		super(EGameMessageCode.PAUSING_GAME, message);
		EGameMessages.FRENCH.add(new French());
		EGameMessages.ENGLISH.add(new English());
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
