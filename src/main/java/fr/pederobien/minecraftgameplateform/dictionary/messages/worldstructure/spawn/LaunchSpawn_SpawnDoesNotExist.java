package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LaunchSpawn_SpawnDoesNotExist extends AbstractDynamicMessage {

	public LaunchSpawn_SpawnDoesNotExist() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de charger le spawn " + args[0] + ", le spawn n’existe pas";
		}
	}

	private static class English extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot launch the spawn " + args[0] + ", it does not exist";
		}
	}
}
