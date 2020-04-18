package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class DimensionSpawn_Defined extends AbstractDynamicMessage {
	/**
	 * Message in French explains the dimensions of the spawn has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the dimensions of the spawn has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public DimensionSpawn_Defined() {
		super(ESpawnMessageCode.DIMENSION_SPAWN__DEFINED);
	}

	private static class French extends DimensionSpawn_Defined {

		@Override
		public String getMessage(String... args) {
			return "Les dimensions du spawn " + args[0] + " sont X=" + args[1] + ", Y=" + args[2] + ", Z=" + args[3];
		}
	}

	private static class English extends DimensionSpawn_Defined {

		@Override
		public String getMessage(String... args) {
			return args[0] + " spawn's dimensions are defined as X=" + args[1] + ", Y=" + args[2] + ", Z=" + args[3];
		}
	}
}
