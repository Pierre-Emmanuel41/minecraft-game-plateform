package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Move_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Move_Explanation(String message) {
		super(ETeamConfigurationMessageCode.MOVE__EXPLANATION, message);
	}

	private static class French extends Move_Explanation {
		public French() {
			super("Pour déplacer un joueur dans une autre équipe");
		}
	}

	private static class English extends Move_Explanation {
		public English() {
			super("To move a player to another team");
		}
	}
}
