package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class LaunchSpawn_SpawnDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the given name does not refer to an existing spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the given name does not refer to an existing spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_SpawnDoesNotExist() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST);
	}

	private static class French extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de charger le spawn " + args[0] + ", le spawn n�existe pas";
		}
	}

	private static class English extends LaunchSpawn_SpawnDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot launch the spawn " + args[0] + ", it does not exist";
		}
	}
}
