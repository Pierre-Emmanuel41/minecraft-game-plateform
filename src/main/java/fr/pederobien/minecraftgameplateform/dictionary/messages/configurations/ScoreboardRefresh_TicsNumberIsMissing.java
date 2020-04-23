package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_TicsNumberIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the number of server's tics for the scoreboard refresh has not been furnished.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the number of server's tics for the scoreboard refresh has not been furnished.
	 */
	public static final IMessage ENGLISH = new English();

	public ScoreboardRefresh_TicsNumberIsMissing(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__TICS_NUMBER_IS_MISSING, message);
	}

	private static class French extends ScoreboardRefresh_TicsNumberIsMissing {
		public French() {
			super("Impossible de définir la fréquence de rafraichissement du scoreboard, il manque le nombre de tics serveur");
		}
	}

	private static class English extends ScoreboardRefresh_TicsNumberIsMissing {
		public English() {
			super("Cannot set the scoreboard refresh frequency, the number of server's tics is missing");
		}
	}
}
