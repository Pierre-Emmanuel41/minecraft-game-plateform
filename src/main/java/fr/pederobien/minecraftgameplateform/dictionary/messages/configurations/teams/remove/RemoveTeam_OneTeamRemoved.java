package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_OneTeamRemoved extends AbstractDynamicMessage {

	public RemoveTeam_OneTeamRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__ONE_TEAM_REMOVED);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemoveTeam_OneTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "L'équipe " + args[0] + " a été supprimée de la configuration " + args[1];
		}
	}

	private static class English extends RemoveTeam_OneTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "The team " + args[0] + " has been removed from configuration " + args[1];
		}
	}
}
