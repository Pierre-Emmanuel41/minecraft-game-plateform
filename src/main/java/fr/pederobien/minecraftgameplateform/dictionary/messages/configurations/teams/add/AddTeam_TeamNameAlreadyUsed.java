package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameAlreadyUsed extends AbstractDynamicMessage {
	/**
	 * Message in French when the team's name is already used by another team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the team's name is already used by another team.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_TeamNameAlreadyUsed() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_ALREADY_USED);
	}

	private static class French extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "L'équipe " + args[0] + " existe déjà";
		}
	}

	private static class English extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "The team " + args[0] + " already exists";
		}
	}
}
