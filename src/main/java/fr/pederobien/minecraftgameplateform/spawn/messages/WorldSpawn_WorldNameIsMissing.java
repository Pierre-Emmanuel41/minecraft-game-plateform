package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class WorldSpawn_WorldNameIsMissing extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
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
