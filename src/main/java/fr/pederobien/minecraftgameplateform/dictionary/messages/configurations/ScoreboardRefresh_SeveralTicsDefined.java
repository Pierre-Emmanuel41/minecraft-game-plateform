package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ScoreboardRefresh_SeveralTicsDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ScoreboardRefresh_SeveralTicsDefined() {
		super(EGameConfigurationMessageCode.SCOREBOARD_REFRESH__SEVERAL_TICS_DEFINED);
	}

	private static class French extends ScoreboardRefresh_SeveralTicsDefined {
		@Override
		public String getMessage(Object... args) {
			return "Le scoreboard est rafraichit tous les " + args[0] + " tics serveur";
		}
	}

	private static class English extends ScoreboardRefresh_SeveralTicsDefined {
		@Override
		public String getMessage(Object... args) {
			return "Scoreboard is refreshed each " + args[0] + " server tics";
		}
	}
}
