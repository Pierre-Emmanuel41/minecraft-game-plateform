package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LaunchSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_Explanation(String message) {
		super(ESpawnMessageCode.LAUNCH_SPAWN__EXPLANATION, message);
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
