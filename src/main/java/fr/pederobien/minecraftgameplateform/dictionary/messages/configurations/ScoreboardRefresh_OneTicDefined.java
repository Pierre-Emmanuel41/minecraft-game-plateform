package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_OneTicDefined extends AbstractNotDynamicMessage {

	public ScoreboardRefresh_OneTicDefined(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__ONE_TICK_DEFINED, message);
		EGameConfigurationMessages.FRENCH.add(new French());
		EGameConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends ScoreboardRefresh_OneTicDefined {
		public French() {
			super("Le scoreboard est rafraichit à chaque tic serveur");
		}
	}

	private static class English extends ScoreboardRefresh_OneTicDefined {
		public English() {
			super("Scoreboard is refreshed each server ticK");
		}
	}
}
