package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ScoreboardRefresh_SeveralTicsDefined extends AbstractDynamicMessage {
	/**
	 * Message in French when the scoreboard refresh frequency correspond to several server tics.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the scoreboard refresh frequency correspond to several server tics.
	 */
	public static final IMessage ENGLISH = new English();

	public ScoreboardRefresh_SeveralTicsDefined() {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__SEVERAL_TICS_DEFINED);
	}

	private static class French extends ScoreboardRefresh_SeveralTicsDefined {
		@Override
		public String getMessage(String... args) {
			return "Le scoreboard est rafraichit tous les " + args[0] + " tics serveur";
		}
	}

	private static class English extends ScoreboardRefresh_SeveralTicsDefined {
		@Override
		public String getMessage(String... args) {
			return "Scoreboard is refreshed each " + args[0] + " server tics";
		}
	}
}
