package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LaunchSpawn_Explanation extends AbstractNotDynamicMessage {

	public LaunchSpawn_Explanation(String message) {
		super(ESpawnMessageCode.LAUNCH_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends LaunchSpawn_Explanation {
		public French() {
			super("Pour charger un spawn dans le monde");
		}
	}

	private static class English extends LaunchSpawn_Explanation {
		public English() {
			super("To launch a spawn in the world");
		}
	}
}
