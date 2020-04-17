package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RenameSpawn_SpawnRenamed extends AbstractDynamicMessage {
	/**
	 * Message in French explains a spawn with the given name has been renamed.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains a spawn with the given name has been renamed.
	 */
	public static final IMessage ENGLISH = new English();

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
