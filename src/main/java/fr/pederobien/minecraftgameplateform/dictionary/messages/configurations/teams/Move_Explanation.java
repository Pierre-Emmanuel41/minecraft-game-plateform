package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Move_Explanation extends AbstractNotDynamicMessage {

	public Move_Explanation(String message) {
		super(ETeamConfigurationMessageCode.MOVE__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Move_Explanation {
		public French() {
			super("Pour déplacer un joueur dans une autre équipe");
		}
	}

	private static class English extends Move_Explanation {
		public English() {
			super("To move a player to another team");
		}
	}
}
