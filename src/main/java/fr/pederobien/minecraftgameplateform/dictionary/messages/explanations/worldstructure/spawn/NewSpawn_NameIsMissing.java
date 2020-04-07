package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NewSpawn_NameIsMissing extends AbstractMessage {
	/**
	 * Message in French explains the name is missing to create a new spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the name is missing to create a new spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public NewSpawn_NameIsMissing() {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_IS_MISSING);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends NewSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de créer un nouveau spawn, il manque le nom";
		}
	}

	private static class English extends NewSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot create a new spawn, the name is missing";
		}
	}
}
