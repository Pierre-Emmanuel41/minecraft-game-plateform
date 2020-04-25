package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamAdded extends AbstractDynamicMessage {
	/**
	 * Message in French when a team has been successfully added.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a team has been successfully added.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_TeamAdded() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_ADDED);
	}

	private static class French extends AddTeam_TeamAdded {
		@Override
		public String getMessage(String... args) {
			return "Equipe " + args[0] + " ajout�e pour la configuration " + args[1];
		}
	}

	private static class English extends AddTeam_TeamAdded {
		@Override
		public String getMessage(String... args) {
			return "Team " + args[0] + " has been added for configuration " + args[1];
		}
	}
}