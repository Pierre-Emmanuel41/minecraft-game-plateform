package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class CommonWorld_WorldDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the given name does not refer to any world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the given name does not refer to any world.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonWorld_WorldDoesNotExist() {
		super(EWorldStructureMessageCode.COMMON_WORLD__WORLD_DOES_NOT_EXIST);
	}

	private static class French extends CommonWorld_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Le nom \"" + args[0] + "\" ne fait référence à aucun monde";
		}
	}

	private static class English extends CommonWorld_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "The name \"" + args[0] + "\" does not refer to any world";
		}
	}
}
