package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemovePlayer_PlayerNotRegistered extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RemovePlayer_PlayerNotRegistered() {
		super(ETeamRemoveMessageCode.REMOVE_PLAYER__PLAYER_NOT_REGISTERED);
	}

	private static class French extends RemovePlayer_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'enlever le joueur \"" + args[0] + "\" d'une équipe, il n'est pas enregistré pour la configuration " + args[1];
		}
	}

	private static class English extends RemovePlayer_PlayerNotRegistered {
		@Override
		public String getMessage(String... args) {
			return "Cannot remove player \"" + args[0] + "\" from a team, he is not registered for configuration " + args[1];
		}
	}
}
