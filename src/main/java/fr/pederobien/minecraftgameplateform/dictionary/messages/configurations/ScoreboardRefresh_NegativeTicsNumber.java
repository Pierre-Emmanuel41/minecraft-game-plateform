package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_NegativeTicsNumber extends AbstractNotDynamicMessage {

	public ScoreboardRefresh_NegativeTicsNumber(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__NEGATIVE_TICS_NUMBER, message);
		EGameConfigurationMessages.FRENCH.add(new French());
		EGameConfigurationMessages.ENGLISH.add(new English());
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
