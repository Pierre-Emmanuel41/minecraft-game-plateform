package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemovePlayer_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_Explanation(String message) {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__EXPLANATION, message);
	}

	private static class French extends RemovePlayer_Explanation {
		public French() {
			super("Pour enlever un joueur d'une équipe");
		}
	}

	private static class English extends RemovePlayer_Explanation {
		public English() {
			super("To remove a player from a team");
		}
	}
}
