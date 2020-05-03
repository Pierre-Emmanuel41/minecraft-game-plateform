package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameSpawn_SpawnRenamed extends AbstractDynamicMessage {

	public RenameSpawn_SpawnRenamed() {
		super(ESpawnMessageCode.RENAME_SPAWN__SPAWN_RENAMED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends RenameSpawn_SpawnRenamed {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " renommé en " + args[1];
		}
	}

	private static class English extends RenameSpawn_SpawnRenamed {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " renamed as " + args[1];
		}
	}
}
