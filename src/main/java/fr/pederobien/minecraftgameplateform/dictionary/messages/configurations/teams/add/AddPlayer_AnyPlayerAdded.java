package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_AnyPlayerAdded extends AbstractNotDynamicMessage {

	public AddPlayer_AnyPlayerAdded(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__ANY_PLAYER_ADDED, message);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddPlayer_AnyPlayerAdded {
		public French() {
			super("Aucun joueur n'a été ajouté");
		}
	}

	private static class English extends AddPlayer_AnyPlayerAdded {
		public English() {
			super("Any player has been added");
		}
	}
}
