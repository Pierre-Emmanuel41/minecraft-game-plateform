package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_TeamsAreTheSame extends AbstractDynamicMessage {
	/**
	 * Message in French when the new player's team is its former team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new player's team is its former team.
	 */
	public static final IMessage ENGLISH = new English();

	public Move_TeamsAreTheSame() {
		super(ETeamConfigurationMessageCode.MOVE__TEAMS_ARE_THE_SAME);
	}

	private static class French extends Move_TeamsAreTheSame {
		@Override
		public String getMessage(String... args) {
			return "Le joueur " + args[0] + " est déjà dans l'équipe " + args[1];
		}
	}

	private static class English extends Move_TeamsAreTheSame {
		@Override
		public String getMessage(String... args) {
			return "The player " + args[0] + " is already in team " + args[1];
		}
	}
}
