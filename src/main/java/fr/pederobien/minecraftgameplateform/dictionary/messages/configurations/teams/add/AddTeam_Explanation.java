package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddTeam_Explanation extends AbstractNotDynamicMessage {

	public AddTeam_Explanation(String message) {
		super(ETeamAddMessageCode.ADD_TEAM__EXPLANATION, message);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddTeam_Explanation {
		public French() {
			super("Pour ajouter une équipe à cette configuration");
		}
	}

	private static class English extends AddTeam_Explanation {
		public English() {
			super("To add a team to this configuration");
		}
	}
}
