package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class WorldSpawn_WorldDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public WorldSpawn_WorldDefined() {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_DEFINED);
	}

	private static class French extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "Le monde du spawn " + args[0] + " est " + args[1];
		}
	}

	private static class English extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " spawn's world is " + args[1];
		}
	}
}
