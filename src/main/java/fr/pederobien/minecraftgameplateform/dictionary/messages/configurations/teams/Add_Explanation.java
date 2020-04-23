package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Add_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "add" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "add" do.
	 */
	public static final IMessage ENGLISH = new English();

	public Add_Explanation(String message) {
		super(ETeamConfigurationMessageCode.ADD__EXPLANATION, message);
	}

	private static class French extends Add_Explanation {
		public French() {
			super("Pour ajouter une équipe à cette configuration ou un joueur à une équipe");
		}
	}

	private static class English extends Add_Explanation {
		public English() {
			super("To add a team to this configuration or a player to a team");
		}

	}
}
