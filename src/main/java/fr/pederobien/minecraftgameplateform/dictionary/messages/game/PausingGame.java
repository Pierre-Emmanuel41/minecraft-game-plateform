package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class PausingGame extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
