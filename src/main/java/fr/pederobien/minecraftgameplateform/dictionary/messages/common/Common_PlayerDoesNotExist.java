package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_PlayerDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in English when the player's name does not correspond to a player.
	 */
	public static final IMessage ENGLISH = new English();

	public Common_PlayerDoesNotExist() {
		super(ECommonMessageCode.COMMON__PLAYER_DOES_NOT_EXIST);
		ECommonMessages.FRENCH.add(new French());
	}

	private static class French extends Common_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return args[0] + " n'existe pas";
		}
	}

	private static class English extends Common_PlayerDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return args[0] + " does not exist";
		}
	}
}
