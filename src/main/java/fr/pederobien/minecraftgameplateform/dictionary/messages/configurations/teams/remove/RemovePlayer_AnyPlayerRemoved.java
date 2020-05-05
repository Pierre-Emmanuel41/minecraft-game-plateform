package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_AnyPlayerRemoved extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_AnyPlayerRemoved(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__ANY_PLAYER_REMOVED, message);
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
