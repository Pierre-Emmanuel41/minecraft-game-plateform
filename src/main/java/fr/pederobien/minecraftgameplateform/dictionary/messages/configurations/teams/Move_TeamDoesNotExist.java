package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_TeamDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the new player's team name does not correspond to a team for a configuration.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new player's team name does not correspond to a team for a configuration.
	 */
	public static final IMessage ENGLISH = new English();

	public Move_TeamDoesNotExist() {
		super(ETeamConfigurationMessageCode.MOVE__TEAM_DOES_NOT_EXIST);
	}

	private static class French extends Move_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de changer l'�quipe du joueur " + args[0] + ", l'�quipe \"" + args[1] + "\" n'existe pas pour la configuration " + args[2];
		}
	}

	private static class English extends Move_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player " + args[0] + ", the team \"" + args[1] + "\" does not exist for configuration " + args[2];
		}
	}
}