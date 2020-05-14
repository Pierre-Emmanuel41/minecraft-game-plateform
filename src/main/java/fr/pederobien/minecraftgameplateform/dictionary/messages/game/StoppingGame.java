package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class StoppingGame extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
