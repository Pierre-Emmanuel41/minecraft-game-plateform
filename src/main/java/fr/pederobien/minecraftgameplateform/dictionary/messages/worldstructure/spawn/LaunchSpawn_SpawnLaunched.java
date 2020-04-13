package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class LaunchSpawn_SpawnLaunched extends AbstractMessage {
	/**
	 * Message in French when the spawn has been correctly launch in the world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the spawn has been correctly launch in the world.
	 */
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_SpawnLaunched() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_LAUNCHED);
	}

	private static class French extends LaunchSpawn_SpawnLaunched {
		@Override
		public String getMessage(String... args) {
			return "Le spawn " + args[0] + " a été chargé en X=" + args[1] + " Y=" + args[2] + " Z=" + args[3];
		}
	}

	private static class English extends LaunchSpawn_SpawnLaunched {
		@Override
		public String getMessage(String... args) {
			return "The spawn " + args[0] + " has been launched at X=" + args[1] + " Y=" + args[2] + " Z=" + args[3];
		}
	}
}
