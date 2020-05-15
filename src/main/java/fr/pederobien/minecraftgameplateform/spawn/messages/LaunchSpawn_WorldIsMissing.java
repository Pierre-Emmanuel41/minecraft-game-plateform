package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LaunchSpawn_WorldIsMissing extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public LaunchSpawn_WorldIsMissing() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__WORLD_IS_MISSING);
	}

	private static class French extends LaunchSpawn_WorldIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de charger le spawn " + args[0] + ", il manque le nom du monde";
		}
	}

	private static class English extends LaunchSpawn_WorldIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Cannot launch spawn " + args[0] + ", the world's name is missing";
		}
	}
}
