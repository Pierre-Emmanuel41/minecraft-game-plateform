package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerMoved extends AbstractDynamicMessage {

	public Move_PlayerMoved() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_MOVED);
		ETeamConfigurationMessages.FRENCH.add(new French());
		ETeamConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends Move_PlayerMoved {
		@Override
		public String getMessage(String... args) {
			return "Le joueur " + args[0] + " a �t� d�plac� dans l'�quipe " + args[1] + ", ancienne �quipe : " + args[2];
		}
	}

	private static class English extends Move_PlayerMoved {
		@Override
		public String getMessage(String... args) {
			return "The player " + args[0] + " has been moved in team " + args[1] + ", former team : " + args[2];
		}
	}
}
