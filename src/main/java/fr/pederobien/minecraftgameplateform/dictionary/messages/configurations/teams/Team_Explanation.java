package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Team_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Team_Explanation(String message) {
		super(ETeamConfigurationMessageCode.TEAM__EXPLANATION, message);
	}

	private static class French extends Team_Explanation {
		public French() {
			super("Pour gérer les équipes d'une configuration");
		}
	}

	private static class English extends Team_Explanation {
		public English() {
			super("To manage the teams of a configuration");
		}
	}
}
