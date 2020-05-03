package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_TicsNumberIsMissing extends AbstractNotDynamicMessage {

	public ScoreboardRefresh_TicsNumberIsMissing(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__TICS_NUMBER_IS_MISSING, message);
		EGameConfigurationMessages.FRENCH.add(new French());
		EGameConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends ScoreboardRefresh_TicsNumberIsMissing {
		public French() {
			super("Impossible de d�finir la fr�quence de rafraichissement du scoreboard, il manque le nombre de tics serveur");
		}
	}

	private static class English extends ScoreboardRefresh_TicsNumberIsMissing {
		public English() {
			super("Cannot set the scoreboard refresh frequency, the number of server's tics is missing");
		}
	}
}
