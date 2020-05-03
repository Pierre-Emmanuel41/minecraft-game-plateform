package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RemoveSpawn_SpawnRemoved extends AbstractDynamicMessage {

	public RemoveSpawn_SpawnRemoved() {
		super(ESpawnMessageCode.REMOVE_SPAWN__SPAWN_REMOVED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends RemoveSpawn_SpawnRemoved {
		@Override
		public String getMessage(String... args) {
			return "Le spawn " + args[0] + " a été enlevé du " + args[1];
		}
	}

	private static class English extends RemoveSpawn_SpawnRemoved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " removed from the " + args[1];
		}
	}
}
