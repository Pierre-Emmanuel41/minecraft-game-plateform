package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NoConfigurationSetted extends AbstractMessage {
	/**
	 * Message in French when there is no game to launch.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when there is no game to launch.
	 */
	public static final IMessage ENGLISH = new English();

	public NoConfigurationSetted() {
		super(EGameMessageCode.NO_CONFIGURATION_SETTED);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends NoConfigurationSetted {

		@Override
		public String getMessage(String... args) {
			return "Aucune partie selectionnée";
		}
	}

	private static class English extends NoConfigurationSetted {

		@Override
		public String getMessage(String... args) {
			return "No game has been selected";
		}
	}
}
