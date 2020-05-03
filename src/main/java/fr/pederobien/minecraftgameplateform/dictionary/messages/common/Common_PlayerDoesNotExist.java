package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_PlayerDoesNotExist extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_PlayerDoesNotExist() {
		super(ECommonMessageCode.COMMON__PLAYER_DOES_NOT_EXIST);
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
