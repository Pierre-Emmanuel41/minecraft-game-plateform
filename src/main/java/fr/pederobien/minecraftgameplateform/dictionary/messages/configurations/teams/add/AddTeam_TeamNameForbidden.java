package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameForbidden extends AbstractDynamicMessage {
	/**
	 * Message in French when the team's name is forbidden.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the team's name is forbidden.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_TeamNameForbidden() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_FORBIDDEN);
	}

	private static class French extends AddTeam_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "Le nom " + args[0] + " est interdit pour une équipe";
		}
	}

	private static class English extends AddTeam_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "The name " + args[0] + " is forbidden for a team";
		}
	}
}
