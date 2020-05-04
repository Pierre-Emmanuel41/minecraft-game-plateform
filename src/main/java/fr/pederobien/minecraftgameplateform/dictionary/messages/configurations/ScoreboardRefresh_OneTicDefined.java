package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ScoreboardRefresh_OneTicDefined extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
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
