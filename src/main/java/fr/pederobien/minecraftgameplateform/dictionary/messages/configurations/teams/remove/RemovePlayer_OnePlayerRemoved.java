package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_OnePlayerRemoved extends AbstractDynamicMessage {
	/**
	 * Message in French when one player has been removed from its team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when one player has been removed from its team.
	 */
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_OnePlayerRemoved() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ONE_PLAYER_REMOVED);
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
