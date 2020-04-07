package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NewSpawn_NameAlreadyTaken extends AbstractMessage {
	/**
	 * Message in French explain the given name is already taken by another spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explain the given name is already taken by another spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public NewSpawn_NameAlreadyTaken() {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_ALREADY_TAKEN);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends NewSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Un spawn " + args[0] + " existe d�j�";
		}
	}

	private static class English extends NewSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "A spawn " + args[0] + " already exist";
		}
	}
}