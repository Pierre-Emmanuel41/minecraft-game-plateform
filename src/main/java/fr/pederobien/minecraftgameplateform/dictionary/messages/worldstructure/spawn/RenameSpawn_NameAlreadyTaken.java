package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RenameSpawn_NameAlreadyTaken extends AbstractMessage {
	/**
	 * Message in French explain the given name is already taken by another spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explain the given name is already taken by another spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public RenameSpawn_NameAlreadyTaken() {
		super(ESpawnMessageCode.RENAME_SPAWN__NAME_ALREADY_TAKEN);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends RenameSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer le spawn " + args[0] + " en " + args[1] + ", un spawn du même nom existe déjà";
		}
	}

	private static class English extends RenameSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename spawn " + args[0] + " as " + args[1] + ", a spawn with the same name already exist";
		}
	}
}
