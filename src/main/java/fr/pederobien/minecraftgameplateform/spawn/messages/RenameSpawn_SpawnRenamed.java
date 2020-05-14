package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameSpawn_SpawnRenamed extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameSpawn_SpawnRenamed() {
		super(ESpawnMessageCode.RENAME_SPAWN__SPAWN_RENAMED);
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
