package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_AnyTeamRemoved extends AbstractDynamicMessage {
	/**
	 * Message in French when any team has been removed from a configuration.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when any team has been removed from a configuration.
	 */
	public static final IMessage ENGLISH = new English();

	public RemoveTeam_AnyTeamRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__ANY_TEAM_REMOVED);
	}

	private static class French extends RemoveTeam_AnyTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "Aucune équipe n'a été supprimée de la configuration " + args[0];
		}
	}

	private static class English extends RemoveTeam_AnyTeamRemoved {
		@Override
		public String getMessage(String... args) {
			return "Any team has been removed from configuration " + args[0];
		}
	}
}
