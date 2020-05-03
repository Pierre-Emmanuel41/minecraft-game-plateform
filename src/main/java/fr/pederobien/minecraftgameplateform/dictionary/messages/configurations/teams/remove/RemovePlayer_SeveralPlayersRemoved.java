package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_SeveralPlayersRemoved extends AbstractDynamicMessage {

	public RemovePlayer_SeveralPlayersRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__SEVERAL_PLAYERS_REMOVED);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemovePlayer_SeveralPlayersRemoved {
		@Override
		public String getMessage(String... args) {
			return "Les joueurs " + args[0] + " ont été supprimés des équipes " + args[1];
		}
	}

	private static class English extends RemovePlayer_SeveralPlayersRemoved {
		@Override
		public String getMessage(String... args) {
			return "Players " + args[0] + " have been removed from teams " + args[1];
		}
	}
}
