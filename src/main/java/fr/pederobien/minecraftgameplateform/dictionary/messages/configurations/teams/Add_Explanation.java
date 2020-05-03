package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Add_Explanation extends AbstractNotDynamicMessage {

	public Add_Explanation(String message) {
		super(ETeamConfigurationMessageCode.ADD__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Add_Explanation {
		public French() {
			super("Pour ajouter une équipe à cette configuration ou un joueur à une équipe");
		}
	}

	private static class English extends Add_Explanation {
		public English() {
			super("To add a team to this configuration or a player to a team");
		}

	}
}
