package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ScoreboardRefresh_Explanation(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__EXPLANATION, message);
	}

	private static class French extends ScoreboardRefresh_Explanation {
		public French() {
			super("pour définir la fréquence (tics serveur) de rafraichissement du scoreboard de chaque joueur");
		}
	}

	private static class English extends ScoreboardRefresh_Explanation {
		public English() {
			super("to set the number of server’s tic after which the scoreboard of each player is refreshed");
		}
	}
}
