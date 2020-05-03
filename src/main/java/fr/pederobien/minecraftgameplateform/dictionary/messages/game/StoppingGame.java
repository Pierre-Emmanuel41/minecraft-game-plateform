package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class StoppingGame extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public StoppingGame(String message) {
		super(EGameMessageCode.STOPPING_GAME, message);
	}

	private static class French extends StoppingGame {
		public French() {
			super("Arr�t de la partie");
		}
	}

	private static class English extends StoppingGame {
		public English() {
			super("Stopping game");
		}
	}
}
