package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RenameSpawn_NameIsMissing extends AbstractMessage {
	/**
	 * Message in French explains the name is missing to rename a new spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the name is missing to rename a new spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public RenameSpawn_NameIsMissing() {
		super(ESpawnMessageCode.RENAME_SPAWN__NAME_IS_MISSING);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends NewSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer le spawn " + args[0] + ", il manque le nom";
		}
	}

	private static class English extends NewSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename the spawn " + args[0] + ", name is missing";
		}
	}
}
