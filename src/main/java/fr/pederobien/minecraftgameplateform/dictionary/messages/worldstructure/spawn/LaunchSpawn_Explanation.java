package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class LaunchSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "launch" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "launch" do.
	 */
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
