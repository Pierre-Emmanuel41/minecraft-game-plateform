package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Move_PlayerNameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the player's name is missing to change its team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the player's name is missing to change its team.
	 */
	public static final IMessage ENGLISH = new English();

	public Move_PlayerNameIsMissing(String message) {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_NAME_IS_MISSING, message);
	}

	private static class French extends Move_PlayerNameIsMissing {
		public French() {
			super("Impossible de changer l'équipe d'un joueur, il manque le nom du joueur");
		}
	}

	private static class English extends Move_PlayerNameIsMissing {
		public English() {
			super("Cannot change the team of a player, the player's name is missing");
		}
	}
}
