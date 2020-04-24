package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "team add player" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "team add player" do.
	 */
	public static final IMessage ENGLISH = new English();

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
