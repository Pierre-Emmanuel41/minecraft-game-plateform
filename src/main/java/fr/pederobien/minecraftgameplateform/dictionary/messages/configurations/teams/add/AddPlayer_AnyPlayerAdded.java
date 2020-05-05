package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_AnyPlayerAdded extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AddPlayer_AnyPlayerAdded(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__ANY_PLAYER_ADDED, message);
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
