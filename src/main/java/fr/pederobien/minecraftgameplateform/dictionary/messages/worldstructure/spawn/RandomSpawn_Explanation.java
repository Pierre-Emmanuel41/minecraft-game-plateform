package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RandomSpawn_Explanation extends AbstractNotDynamicMessage {

	public RandomSpawn_Explanation(String message) {
		super(ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends RandomSpawn_Explanation {
		public French() {
			super("Pour charger aléatoirement un spawn dans le monde");
		}
	}

	private static class English extends RandomSpawn_Explanation {
		public English() {
			super("To launch randomly a spawn on the world");
		}
	}
}
