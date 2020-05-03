package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_Explanation extends AbstractNotDynamicMessage {

	public RemovePlayer_Explanation(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__EXPLANATION, message);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemovePlayer_Explanation {
		public French() {
			super("Pour enlever un joueur d'une équipe");
		}
	}

	private static class English extends RemovePlayer_Explanation {
		public English() {
			super("To remove a player from a team");
		}
	}
}
