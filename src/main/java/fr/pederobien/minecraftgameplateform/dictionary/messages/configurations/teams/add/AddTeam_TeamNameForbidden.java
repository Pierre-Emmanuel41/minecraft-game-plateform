package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameForbidden extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AddTeam_TeamNameForbidden() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_FORBIDDEN);
	}

	private static class French extends AddTeam_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'équipe " + args[0] + " à la configuration " + args[1] + ", ce nom  est interdit pour une équipe";
		}
	}

	private static class English extends AddTeam_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team " + args[0] + " to configuration " + args[1] + ", this name is forbidden for a team";
		}
	}
}
