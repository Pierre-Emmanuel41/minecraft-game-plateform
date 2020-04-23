package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_NegativeTicsNumber extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains that the number of server's tics to refresh the scoreboard mus be strictly positive.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains that the number of server's tics to refresh the scoreboard mus be strictly positive.
	 */
	public static final IMessage ENGLISH = new English();

	public ScoreboardRefresh_NegativeTicsNumber(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__NEGATIVE_TICS_NUMBER, message);
	}

	private static class French extends ScoreboardRefresh_NegativeTicsNumber {
		public French() {
			super("Le nombre de tics doit être strictement positif");
		}
	}

	private static class English extends ScoreboardRefresh_NegativeTicsNumber {
		public English() {
			super("The number of tics must be strictly positive");
		}
	}
}
