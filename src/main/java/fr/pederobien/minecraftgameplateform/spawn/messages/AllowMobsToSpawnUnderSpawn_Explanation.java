package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AllowMobsToSpawnUnderSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AllowMobsToSpawnUnderSpawn_Explanation(String message) {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__EXPLANATION, message);
	}

	private static class French extends AllowMobsToSpawnUnderSpawn_Explanation {
		public French() {
			super("Pour autoriser ou non le spawn de mob sous le spawn");
		}
	}

	private static class English extends AllowMobsToSpawnUnderSpawn_Explanation {
		public English() {
			super("To allow or not the mobs's spawn under the spawn");
		}
	}
}
