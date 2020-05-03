package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameAlreadyUsed extends AbstractDynamicMessage {

	public AddTeam_TeamNameAlreadyUsed() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_ALREADY_USED);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'�quipe " + args[0] + " to configuration " + args[1] + ", cette �quipe existe d�j�";
		}
	}

	private static class English extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team " + args[0] + " to configuration " + args[1] + ", this team already exists";
		}
	}
}
