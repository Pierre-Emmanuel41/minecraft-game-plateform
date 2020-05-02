package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the player's name does not correspond to an existing player.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the player's name does not correspond to an existing player.
	 */
	public static final IMessage ENGLISH = new English();

	public Move_PlayerDoesNotExist() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_DOES_NOT_EXIST);
	}

	private static class French extends Move_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier l'équipe du joueur \"" + args[0] + "\", ce joueur n'existe pas";
		}
	}

	private static class English extends Move_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player \"" + args[0] + "\", this player does not exist";
		}
	}
}
