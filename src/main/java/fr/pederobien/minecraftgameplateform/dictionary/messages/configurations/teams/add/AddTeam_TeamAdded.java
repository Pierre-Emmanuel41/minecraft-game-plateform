package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamAdded extends AbstractDynamicMessage {

	public AddTeam_TeamAdded() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_ADDED);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddTeam_TeamAdded {
		@Override
		public String getMessage(String... args) {
			return "Equipe " + args[0] + " ajoutée pour la configuration " + args[1];
		}
	}

	private static class English extends AddTeam_TeamAdded {
		@Override
		public String getMessage(String... args) {
			return "Team " + args[0] + " has been added for configuration " + args[1];
		}
	}
}
