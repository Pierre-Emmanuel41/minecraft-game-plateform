package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "scoreboardrefresh" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "scoreboardrefresh" do.
	 */
	public static final IMessage ENGLISH = new English();

	public ScoreboardRefresh_Explanation(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__EXPLANATION, message);
	}

	private static class French extends ScoreboardRefresh_Explanation {
		public French() {
			super("pour d�finir la fr�quence (tics serveur) de rafraichissement du scoreboard de chaque joueur");
		}
	}

	private static class English extends ScoreboardRefresh_Explanation {
		public English() {
			super("to set the number of server�s tic after which the scoreboard of each player is refreshed");
		}
	}
}