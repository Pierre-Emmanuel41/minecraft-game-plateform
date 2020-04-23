package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_OneTicDefined extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the scoreboard is refreshed each server tick.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the scoreboard is refreshed each server tick.
	 */
	public static final IMessage ENGLISH = new English();

	public ScoreboardRefresh_OneTicDefined(String message) {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__ONE_TICK_DEFINED, message);
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
