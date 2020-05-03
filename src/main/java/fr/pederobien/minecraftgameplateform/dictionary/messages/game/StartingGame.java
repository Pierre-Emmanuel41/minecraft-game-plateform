package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class StartingGame extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	protected StartingGame() {
		super(EGameMessageCode.STARTING_GAME);
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
