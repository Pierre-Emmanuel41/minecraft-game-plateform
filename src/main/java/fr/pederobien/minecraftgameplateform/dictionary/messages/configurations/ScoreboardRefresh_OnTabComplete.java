package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_OnTabComplete extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ScoreboardRefresh_OnTabComplete(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__ON_TAB_COMPLETE, message);
	}

	private static class French extends ScoreboardRefresh_OnTabComplete {
		public French() {
			super("<nombre de tic serveur (entier)>");
		}
	}

	private static class English extends ScoreboardRefresh_OnTabComplete {
		public English() {
			super("<number of server tics (integer)>");
		}
	}
}
