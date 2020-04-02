package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftgameplateform.dictionary.EMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class StartingGame extends AbstractMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	protected StartingGame() {
		super(EMessageCode.STARTING_GAME);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Lancement de la partie : " + args[0];
		}
	}

	private static class English extends StartingGame {

		@Override
		public String getMessage(String... args) {
			return "Starting game : " + args[0];
		}
	}
}
