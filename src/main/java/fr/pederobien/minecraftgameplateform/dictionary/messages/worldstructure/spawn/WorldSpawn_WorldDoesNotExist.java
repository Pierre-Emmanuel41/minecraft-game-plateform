package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class WorldSpawn_WorldDoesNotExist extends AbstractMessage {
	/**
	 * Message in French when the given name does not refer to any world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the given name does not refer to any world.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_WorldDoesNotExist() {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_DOES_NOT_EXIST);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends WorldSpawn_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Le nom " + args[0] + " ne fait référence à aucun monde";
		}
	}

	private static class English extends WorldSpawn_WorldDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "The name " + args[0] + " does not refer to any world";
		}
	}
}
