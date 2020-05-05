package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DimensionSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DimensionSpawn_Explanation(String message) {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION, message);
	}

	private static class French extends DimensionSpawn_Explanation {
		public French() {
			super("Pour définir les dimensions du spawn");
		}
	}

	private static class English extends DimensionSpawn_Explanation {
		public English() {
			super("to set spawn's dimensions");
		}
	}
}
