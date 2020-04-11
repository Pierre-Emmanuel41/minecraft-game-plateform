package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class LaunchSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "launch" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "launch" do.
	 */
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_Explanation() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends LaunchSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour charger un spawn dans le monde";
		}
	}

	private static class English extends LaunchSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To launch a spawn in the world";
		}
	}
}
