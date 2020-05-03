package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerNotRegistered extends AbstractDynamicMessage {

	public Move_PlayerNotRegistered() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_NOT_REGISTERED);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Move_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Impossible de changer l'équipe du joueur " + args[0] + ", ce joueur n'est pas dans une équipe";
		}
	}

	private static class English extends Move_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player " + args[0] + ", this player is not registered in a team";
		}
	}
}
