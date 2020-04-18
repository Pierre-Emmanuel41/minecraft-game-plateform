package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class WorldSpawn_WorldNameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when no name has been furnished to set the spawn's world.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when no name has been furnished to set the spawn's world.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_WorldNameIsMissing(String message) {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_NAME_IS_MISSING, message);
	}

	private static class French extends WorldSpawn_WorldNameIsMissing {
		public French() {
			super("Impossible de définir le monde du spawn, il manque le nom");
		}
	}

	private static class English extends WorldSpawn_WorldNameIsMissing {
		public English() {
			super("Cannot set the spawn's world, the name is missing");
		}
	}
}
