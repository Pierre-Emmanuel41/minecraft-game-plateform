package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RemoveSpawn_SpawnRemoved extends AbstractMessage {
	/**
	 * Message in French when a spawn has been correctly removed from the world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a spawn has been correctly removed from the world.
	 */
	public static final IMessage ENGLISH = new English();

	public RemoveSpawn_SpawnRemoved() {
		super(ESpawnMessageCode.REMOVE_SPAWN__SPAWN_REMOVED);
	}

	private static class French extends RemoveSpawn_SpawnRemoved {
		@Override
		public String getMessage(String... args) {
			return "Le spawn " + args[0] + " a été enlevé du monde";
		}
	}

	private static class English extends RemoveSpawn_SpawnRemoved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " removed from the world";
		}
	}
}
