package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Remove_Explanation extends AbstractNotDynamicMessage {

	public Remove_Explanation(String message) {
		super(ETeamConfigurationMessageCode.REMOVE__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Remove_Explanation {
		public French() {
			super("Pour enlever une équipe de cette configuration ou un joueur d'une équipe");
		}
	}

	private static class English extends Remove_Explanation {
		public English() {
			super("To remove a team from this configuration or a player from a team");
		}
	}
}
