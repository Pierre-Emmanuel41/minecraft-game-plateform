package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class LaunchSpawn_SpawnLaunched extends AbstractDynamicMessage {
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
			return "Le spawn " + args[0] + " a été chargé dans le " + args[1] + " en X=" + args[2] + " Y=" + args[3] + " Z=" + args[4];
		}
	}

	private static class English extends LaunchSpawn_SpawnLaunched {
		@Override
		public String getMessage(String... args) {
			return "The spawn " + args[0] + " has been launched in " + args[1] + " at X=" + args[2] + " Y=" + args[3] + " Z=" + args[4];
		}
	}
}
