package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddPlayer_Explanation(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__EXPLANATION, message);
	}

	private static class French extends AddPlayer_Explanation {
		public French() {
			super("Pour ajouter un joueur à une équipe");
		}
	}

	private static class English extends AddPlayer_Explanation {
		public English() {
			super("To add players to a team");
		}
	}
}
