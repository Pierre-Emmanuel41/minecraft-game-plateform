package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_AnyTeamRemoved extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RemoveTeam_AnyTeamRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__ANY_TEAM_REMOVED);
	}

	private static class French extends RemoveTeam_AnyTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "Aucune �quipe n'a �t� supprim�e de la configuration " + args[0];
		}
	}

	private static class English extends RemoveTeam_AnyTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "Any team has been removed from configuration " + args[0];
		}
	}
}
