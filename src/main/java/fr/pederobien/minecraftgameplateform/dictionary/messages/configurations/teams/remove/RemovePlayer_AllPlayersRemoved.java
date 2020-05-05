package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_AllPlayersRemoved extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_AllPlayersRemoved(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ALL_PLAYERS_REMOVED, message);
	}

	private static class French extends RemovePlayer_AllPlayersRemoved {
		public French() {
			super("Tous les joueurs ont été retirés de leurs équipes");
		}
	}

	private static class English extends RemovePlayer_AllPlayersRemoved {
		public English() {
			super("All players have been removed from their team");
		}
	}
}
