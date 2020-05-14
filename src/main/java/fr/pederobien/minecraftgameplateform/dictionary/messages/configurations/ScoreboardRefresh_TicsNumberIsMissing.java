package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_TicsNumberIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
