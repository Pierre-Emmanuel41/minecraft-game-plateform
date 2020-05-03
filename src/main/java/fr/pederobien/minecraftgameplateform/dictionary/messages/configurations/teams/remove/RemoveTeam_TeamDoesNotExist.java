package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveTeam_TeamDoesNotExist extends AbstractDynamicMessage {

	public RemoveTeam_TeamDoesNotExist() {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__TEAM_DOES_NOT_EXIST);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemoveTeam_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de supprimer l'équipe \"" + args[0] + "\" de la configuration " + args[1] + ", elle n'existe pas";
		}
	}

	private static class English extends RemoveTeam_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot remove team \"" + args[0] + "\" from configuration " + args[1] + ", it does not exist";
		}
	}
}
