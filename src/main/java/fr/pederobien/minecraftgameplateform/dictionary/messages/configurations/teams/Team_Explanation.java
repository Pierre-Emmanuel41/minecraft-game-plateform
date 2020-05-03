package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Team_Explanation extends AbstractNotDynamicMessage {

	public Team_Explanation(String message) {
		super(ETeamConfigurationMessageCode.TEAM__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
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
