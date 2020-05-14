package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RandomSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RandomSpawn_Explanation(String message) {
		super(ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION, message);
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
