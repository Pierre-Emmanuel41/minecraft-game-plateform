package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_WorldDoesNotExist extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Common_WorldDoesNotExist() {
		super(ECommonMessageCode.COMMON_WORLD_DOES_NOT_EXIST);
	}

	private static class French extends Common_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Le nom \"" + args[0] + "\" ne fait référence à aucun monde";
		}
	}

	private static class English extends Common_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "The name \"" + args[0] + "\" does not refer to any world";
		}
	}
}
