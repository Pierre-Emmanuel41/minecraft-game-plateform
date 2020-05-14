package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_NegativeTicsNumber extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
