package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CommonWorld_WorldDoesNotExist extends AbstractDynamicMessage {

	public CommonWorld_WorldDoesNotExist() {
		super(EWorldStructureMessageCode.COMMON_WORLD__WORLD_DOES_NOT_EXIST);
		EWorldStructureMessages.FRENCH.add(new French());
		EWorldStructureMessages.ENGLISH.add(new English());
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
