package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerDoesNotExist extends AbstractDynamicMessage {

	public Move_PlayerDoesNotExist() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_DOES_NOT_EXIST);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Move_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier l'�quipe du joueur \"" + args[0] + "\", ce joueur n'existe pas";
		}
	}

	private static class English extends Move_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player \"" + args[0] + "\", this player does not exist";
		}
	}
}
