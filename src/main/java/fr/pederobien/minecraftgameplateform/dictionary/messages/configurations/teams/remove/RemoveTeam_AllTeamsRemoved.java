package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_AllTeamsRemoved extends AbstractDynamicMessage {
	/**
	 * Message in French when all teams from a configuration have been removed.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in French when all teams from a configuration have been removed.
	 */
	public static final IMessage ENGLISH = new English();

	public RemoveTeam_AllTeamsRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__ALL_TEAMS_REMOVED);
	}

	private static class French extends RemoveTeam_AllTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "Toutes les équipes de la configuration " + args[0] + " ont été enlevées : " + args[1];
		}
	}

	private static class English extends RemoveTeam_AllTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "All teams from configuration " + args[0] + " have been removed : " + args[1];
		}
	}
}
