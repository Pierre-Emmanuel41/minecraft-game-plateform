package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_PlayerNotRegistered extends AbstractDynamicMessage {

	public RemovePlayer_PlayerNotRegistered() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__PLAYER_NOT_REGISTERED);
		ETeamRemoveMessages.FRENCH.add(new French());
		ETeamRemoveMessages.ENGLISH.add(new English());
	}

	private static class French extends RemovePlayer_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'enlever le joueur \"" + args[0] + "\" d'une �quipe, il n'est pas enregistr� pour la configuration " + args[1];
		}
	}

	private static class English extends RemovePlayer_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Cannot remove player \"" + args[0] + "\" from a team, he is not registered for configuration " + args[1];
		}
	}
}
