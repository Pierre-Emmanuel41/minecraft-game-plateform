package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_OnePlayerRemoved extends AbstractDynamicMessage {

	public RemovePlayer_OnePlayerRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ONE_PLAYER_REMOVED);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemovePlayer_OnePlayerRemoved {
		@Override
		public String getMessage(String... args) {
			return "Le joueur " + args[0] + " a été enlevé de l'équipe " + args[1];
		}
	}

	private static class English extends RemovePlayer_OnePlayerRemoved {
		@Override
		public String getMessage(String... args) {
			return "Player " + args[0] + " has been removed from team " + args[1];
		}
	}
}
