package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_TeamsAreTheSame extends AbstractDynamicMessage {

	public Move_TeamsAreTheSame() {
		super(ETeamConfigurationMessageCode.MOVE__TEAMS_ARE_THE_SAME);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
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
