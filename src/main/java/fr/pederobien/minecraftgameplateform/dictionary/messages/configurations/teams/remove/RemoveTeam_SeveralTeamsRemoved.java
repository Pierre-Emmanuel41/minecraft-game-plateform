package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_SeveralTeamsRemoved extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RemoveTeam_SeveralTeamsRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__SEVERAL_TEAMS_REMOVED);
	}

	private static class French extends RemoveTeam_SeveralTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "Les équipes " + args[0] + " ont été supprimées de la configuration " + args[1];
		}
	}

	private static class English extends RemoveTeam_SeveralTeamsRemoved {
		@Override
		public String getMessage(String... args) {
			return "Teams " + args[0] + " haven been removed from configuration " + args[1];
		}
	}
}
