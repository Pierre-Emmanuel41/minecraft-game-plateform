package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_SeveralTeamsRemoved extends AbstractDynamicMessage {

	public RemoveTeam_SeveralTeamsRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__SEVERAL_TEAMS_REMOVED);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemoveTeam_SeveralTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "Les �quipes " + args[0] + " ont �t� supprim�es de la configuration " + args[1];
		}
	}

	private static class English extends RemoveTeam_SeveralTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "Teams " + args[0] + " haven been removed from configuration " + args[1];
		}
	}
}
