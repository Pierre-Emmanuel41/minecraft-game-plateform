package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NewSpawn_SpawnCreated extends AbstractMessage {
	/**
	 * Message in French explains a spawn with the given name has been created.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains a spawn with the given name has been created.
	 */
	public static final IMessage ENGLISH = new English();

	public NewSpawn_SpawnCreated() {
		super(ESpawnMessageCode.NEW_SPAWN__SPAWN_CREATED);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends NewSpawn_SpawnCreated {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " créé";
		}
	}

	private static class English extends NewSpawn_SpawnCreated {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " created";
		}
	}
}
