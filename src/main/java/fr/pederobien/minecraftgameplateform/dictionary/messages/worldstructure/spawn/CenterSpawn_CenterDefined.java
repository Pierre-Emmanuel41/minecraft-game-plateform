package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class CenterSpawn_CenterDefined extends AbstractDynamicMessage {
	/**
	 * Message in French explains the center has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the center has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public CenterSpawn_CenterDefined() {
		super(ESpawnMessageCode.CENTER_SPAWN__CENTER_DEFINED);
	}

	private static class French extends CenterSpawn_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "Le centre du spawn est défini en " + args[0] + " " + args[1] + " " + args[2];
		}
	}

	private static class English extends CenterSpawn_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "The spawn's center is defined in " + args[0] + " " + args[1] + " " + args[2];
		}
	}
}
