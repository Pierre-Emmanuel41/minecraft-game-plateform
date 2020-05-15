package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_PlayerAlreadyRegistered extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddPlayer_PlayerAlreadyRegistered() {
		super(ETeamAddMessageCode.ADD_PLAYER__PLAYER_ALREADY_REGISTERED);
	}

	private static class French extends AddPlayer_PlayerAlreadyRegistered {
		@Override
		public String getMessage(Object... args) {
			return "Impossible d'ajouter le joueur " + args[0] + " � l'�quipe " + args[1] + ", ce joueur est d�j� dans l'�quipe " + args[2];
		}
	}

	private static class English extends AddPlayer_PlayerAlreadyRegistered {
		@Override
		public String getMessage(Object... args) {
			return "Cannot add player \"" + args[0] + " to team " + args[1] + ", this player is alreay registered in team " + args[2];
		}
	}
}
