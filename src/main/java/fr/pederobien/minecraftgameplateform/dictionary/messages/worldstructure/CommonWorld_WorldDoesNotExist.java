package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CommonWorld_WorldDoesNotExist extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CommonWorld_WorldDoesNotExist() {
		super(EWorldStructureMessageCode.COMMON_WORLD__WORLD_DOES_NOT_EXIST);
	}

	private static class French extends CommonWorld_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Le nom \"" + args[0] + "\" ne fait r�f�rence � aucun monde";
		}
	}

	private static class English extends CommonWorld_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "The name \"" + args[0] + "\" does not refer to any world";
		}
	}
}
