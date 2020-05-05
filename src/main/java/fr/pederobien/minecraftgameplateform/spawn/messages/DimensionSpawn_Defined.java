package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DimensionSpawn_Defined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
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
