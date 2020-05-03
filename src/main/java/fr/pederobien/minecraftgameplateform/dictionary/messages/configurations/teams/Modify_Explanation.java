package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Modify_Explanation extends AbstractNotDynamicMessage {

	public Modify_Explanation(String message) {
		super(ETeamConfigurationMessageCode.MODIFY__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Modify_Explanation {
		public French() {
			super("Pour modifier les caractéristiques d'une équipe");
		}
	}

	private static class English extends Modify_Explanation {
		public English() {
			super("To modify team's characteristics");
		}
	}
}
