package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LaunchSpawn_SpawnLaunched extends AbstractDynamicMessage {

	public LaunchSpawn_SpawnLaunched() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_LAUNCHED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends LaunchSpawn_SpawnLaunched {
		@Override
		public String getMessage(String... args) {
			return "Le spawn " + args[0] + " a �t� charg� dans le " + args[1] + " en X=" + args[2] + " Y=" + args[3] + " Z=" + args[4];
		}
	}

	private static class English extends LaunchSpawn_SpawnLaunched {
		@Override
		public String getMessage(String... args) {
			return "The spawn " + args[0] + " has been launched in " + args[1] + " at X=" + args[2] + " Y=" + args[3] + " Z=" + args[4];
		}
	}
}
