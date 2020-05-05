package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_OneTeamRemoved extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RemoveTeam_OneTeamRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__ONE_TEAM_REMOVED);
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
