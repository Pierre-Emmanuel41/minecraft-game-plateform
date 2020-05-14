package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_AllPlayersRemoved extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RemovePlayer_AllPlayersRemoved(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ALL_PLAYERS_REMOVED, message);
	}

	private static class French extends RemovePlayer_AllPlayersRemoved {
		public French() {
			super("Tous les joueurs ont �t� retir�s de leurs �quipes");
		}
	}

	private static class English extends RemovePlayer_AllPlayersRemoved {
		public English() {
			super("All players have been removed from their team");
		}
	}
}
