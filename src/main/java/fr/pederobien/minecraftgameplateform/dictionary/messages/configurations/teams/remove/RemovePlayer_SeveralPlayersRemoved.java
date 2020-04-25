package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_SeveralPlayersRemoved extends AbstractDynamicMessage {
	/**
	 * Message in French when several players haven removed from their teams.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when several players haven removed from their teams.
	 */
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_SeveralPlayersRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__SEVERAL_PLAYERS_REMOVED);
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
