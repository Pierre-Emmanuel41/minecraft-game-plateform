package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_AnyExistingTeam extends AbstractDynamicMessage {

	public List_AnyExistingTeam() {
		super(ETeamConfigurationMessageCode.LIST__ANY_EXISTING_TEAM);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends List_AnyExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "Il n'existe aucune équipe pour la configuration " + args[0];
		}
	}

	private static class English extends List_AnyExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "There is any team for configuration " + args[0];
		}
	}
}
