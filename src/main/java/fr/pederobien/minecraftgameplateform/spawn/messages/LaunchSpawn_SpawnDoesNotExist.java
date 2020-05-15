package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LaunchSpawn_SpawnDoesNotExist extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public LaunchSpawn_SpawnDoesNotExist() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST);
	}

	private static class French extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de charger le spawn " + args[0] + ", le spawn n’existe pas";
		}
	}

	private static class English extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Cannot launch the spawn " + args[0] + ", it does not exist";
		}
	}
}
