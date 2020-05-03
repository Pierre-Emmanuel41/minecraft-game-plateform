package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerNotRegistered extends AbstractDynamicMessage {
	/**
	 * Message in French when the player is not registered in a team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the player is not registered in a team.
	 */
	public static final IMessage ENGLISH = new English();

	public Move_PlayerNotRegistered() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_NOT_REGISTERED);
	}

	private static class French extends Move_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Impossible de changer l'�quipe du joueur " + args[0] + ", ce joueur n'est pas dans une �quipe";
		}
	}

	private static class English extends Move_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player " + args[0] + ", this player is not registered in a team";
		}
	}
}