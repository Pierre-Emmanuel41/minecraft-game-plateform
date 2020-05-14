package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Move_PlayerNameIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
