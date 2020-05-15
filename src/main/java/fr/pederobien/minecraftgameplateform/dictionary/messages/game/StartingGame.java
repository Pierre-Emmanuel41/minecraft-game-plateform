package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class StartingGame extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	protected StartingGame() {
		super(EGameMessageCode.STARTING_GAME);
	}

	private static class French extends StartingGame {

		@Override
		public String getMessage(Object... args) {
			return "Lancement de " + args[0];
		}
	}

	private static class English extends StartingGame {

		@Override
		public String getMessage(Object... args) {
			return "Starting " + args[0];
		}
	}
}
