package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DimensionSpawn_Explanation extends AbstractNotDynamicMessage {

	public DimensionSpawn_Explanation(String message) {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
