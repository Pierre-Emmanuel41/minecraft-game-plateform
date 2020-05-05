package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AddPlayer_Explanation(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__EXPLANATION, message);
	}

	private static class French extends AddPlayer_Explanation {
		public French() {
			super("Pour ajouter un joueur � une �quipe");
		}
	}

	private static class English extends AddPlayer_Explanation {
		public English() {
			super("To add players to a team");
		}
	}
}
