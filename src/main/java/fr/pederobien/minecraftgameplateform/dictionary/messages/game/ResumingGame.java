package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ResumingGame extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ResumingGame(String message) {
		super(EGameMessageCode.RESUMING_GAME, message);
	}

	private static class French extends ResumingGame {
		public French(Object... args) {
			super("Reprise de la partie");
		}
	}

	private static class English extends ResumingGame {
		public English(Object... args) {
			super("Resume");
		}
	}
}
