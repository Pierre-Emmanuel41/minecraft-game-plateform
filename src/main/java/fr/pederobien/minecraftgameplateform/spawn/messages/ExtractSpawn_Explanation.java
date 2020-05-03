package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ExtractSpawn_Explanation extends AbstractNotDynamicMessage {

	public ExtractSpawn_Explanation(String message) {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends DimensionSpawn_Explanation {
		public French() {
			super("Pour extraire du monde les blocs du spawn");
		}
	}

	private static class English extends DimensionSpawn_Explanation {
		public English() {
			super("to extract from the world spawn's blocks");
		}
	}
}
