package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_SeveralExistingTeams extends AbstractDynamicMessage {

	public List_SeveralExistingTeams() {
		super(ETeamConfigurationMessageCode.LIST__SEVERAL_EXISTING_TEAMS);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends List_SeveralExistingTeams {
		@Override
		public String getMessage(String... args) {
			return "Liste des équipes pour la configuration " + args[0] + " :\n" + args[1];
		}
	}

	private static class English extends List_SeveralExistingTeams {
		@Override
		public String getMessage(String... args) {
			return "List of teams for configuration " + args[0] + " :\n" + args[1];
		}
	}
}
