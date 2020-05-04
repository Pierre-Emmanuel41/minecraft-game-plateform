package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_PlayerMoved extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Move_PlayerMoved() {
		super(ETeamConfigurationMessageCode.MOVE__PLAYER_MOVED);
	}

	private static class French extends Move_PlayerMoved {
		@Override
		public String getMessage(String... args) {
			return "Le joueur " + args[0] + " a été déplacé dans l'équipe " + args[1] + ", ancienne équipe : " + args[2];
		}
	}

	private static class English extends Move_PlayerMoved {
		@Override
		public String getMessage(String... args) {
			return "The player " + args[0] + " has been moved in team " + args[1] + ", former team : " + args[2];
		}
	}
}
