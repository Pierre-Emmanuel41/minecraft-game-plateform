package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_Explanation extends AbstractNotDynamicMessage {

	public AddPlayer_Explanation(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__EXPLANATION, message);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddPlayer_Explanation {
		public French() {
			super("Pour ajouter un joueur à une équipe");
		}
	}

	private static class English extends AddPlayer_Explanation {
		public English() {
			super("To add players to a team");
		}
	}
}
