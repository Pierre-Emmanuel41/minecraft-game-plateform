package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddTeam_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "team add team" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "team add team" do.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_Explanation(String message) {
		super(ETeamAddMessageCode.ADD_TEAM__EXPLANATION, message);
	}

	private static class French extends AddTeam_Explanation {
		public French() {
			super("Pour ajouter une équipe à cette configuration");
		}
	}

	private static class English extends AddTeam_Explanation {
		public English() {
			super("To add a team to this configuration");
		}
	}
}
