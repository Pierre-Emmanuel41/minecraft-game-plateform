package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_OneExistingTeam extends AbstractDynamicMessage {

	public List_OneExistingTeam() {
		super(ETeamConfigurationMessageCode.LIST__ONE_EXISTING_TEAM);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends List_OneExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "Il y a une équipe enregistrée pour la configuration " + args[0] + ":\n" + args[1];
		}
	}

	private static class English extends List_OneExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "There is one registered team for configuration " + args[0] + " :\n" + args[1];
		}
	}
}
