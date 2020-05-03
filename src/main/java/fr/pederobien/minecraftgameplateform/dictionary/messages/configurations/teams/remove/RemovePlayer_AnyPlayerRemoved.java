package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_AnyPlayerRemoved extends AbstractNotDynamicMessage {

	public RemovePlayer_AnyPlayerRemoved(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ANY_PLAYER_REMOVED, message);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemovePlayer_AnyPlayerRemoved {
		public French() {
			super("Aucun joueur n'a été enlevé");
		}
	}

	private static class English extends RemovePlayer_AnyPlayerRemoved {
		public English() {
			super("Any player has been removed");
		}
	}
}
