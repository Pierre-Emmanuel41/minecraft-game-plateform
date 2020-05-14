package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemoveTeam_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RemoveTeam_Explanation(String message) {
		super(ETeamRemoveMessageCode.REMOVE_TEAM__EXPLANATION, message);
	}

	private static class French extends RemoveTeam_Explanation {
		public French() {
			super("Pour enlever une équipe de cette configuration");
		}
	}

	private static class English extends RemoveTeam_Explanation {
		public English() {
			super("To remove a team from this configuration");
		}
	}
}
