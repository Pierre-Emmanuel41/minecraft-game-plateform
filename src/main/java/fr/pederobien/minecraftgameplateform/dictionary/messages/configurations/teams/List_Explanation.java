package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class List_Explanation extends AbstractNotDynamicMessage {

	public List_Explanation(String message) {
		super(ETeamConfigurationMessageCode.LIST__EXPLANATION, message);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends List_Explanation {
		public French() {
			super("Pour afficher les équipes d'une configuration");
		}
	}

	private static class English extends List_Explanation {
		public English() {
			super("To display the teams of a configuration");
		}
	}
}
