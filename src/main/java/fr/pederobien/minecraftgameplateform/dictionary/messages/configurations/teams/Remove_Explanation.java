package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Remove_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Remove_Explanation(String message) {
		super(ETeamConfigurationMessageCode.REMOVE__EXPLANATION, message);
	}

	private static class French extends Remove_Explanation {
		public French() {
			super("Pour enlever une équipe de cette configuration ou un joueur d'une équipe");
		}
	}

	private static class English extends Remove_Explanation {
		public English() {
			super("To remove a team from this configuration or a player from a team");
		}
	}
}
