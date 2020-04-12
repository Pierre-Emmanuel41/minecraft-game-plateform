package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class WorldSpawn_WorldNameIsMissing extends AbstractMessage {
	/**
	 * Message in French when no name has been furnished to set the spawn's world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when no name has been furnished to set the spawn's world.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_WorldNameIsMissing() {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_NAME_IS_MISSING);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends WorldSpawn_WorldNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de définir le monde du spawn, il manque le nom";
		}
	}

	private static class English extends WorldSpawn_WorldNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot set the spawn's world, the name is missing";
		}
	}
}
