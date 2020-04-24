package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_PlayerAlreadyRegistered extends AbstractDynamicMessage {
	/**
	 * Message in French when a player is already registered in a team for this configuration.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a player is already registered in a team for this configuration.
	 */
	public static final IMessage ENGLISH = new English();

	public AddPlayer_PlayerAlreadyRegistered() {
		super(ETeamAddMessageCode.ADD_PLAYER__PLAYER_ALREADY_REGISTERED);
	}

	private static class French extends AddPlayer_PlayerAlreadyRegistered {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter le joueur " + args[0] + " à l'équipe " + args[1] + ", ce joueur est déjà dans l'équipe " + args[2];
		}
	}

	private static class English extends AddPlayer_PlayerAlreadyRegistered {
		@Override
		public String getMessage(String... args) {
			return "Cannot add player \"" + args[0] + " to team " + args[1] + ", this player is alreay registered in team " + args[2];
		}
	}
}
