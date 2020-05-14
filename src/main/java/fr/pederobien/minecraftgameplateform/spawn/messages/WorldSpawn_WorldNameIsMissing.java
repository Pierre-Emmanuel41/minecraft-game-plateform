package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class WorldSpawn_WorldNameIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public WorldSpawn_WorldNameIsMissing(String message) {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_NAME_IS_MISSING, message);
	}

	private static class French extends WorldSpawn_WorldNameIsMissing {
		public French() {
			super("Impossible de d�finir le monde du spawn, il manque le nom");
		}
	}

	private static class English extends WorldSpawn_WorldNameIsMissing {
		public English() {
			super("Cannot set the spawn's world, the name is missing");
		}
	}
}
