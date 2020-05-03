package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LaunchSpawn_WorldIsMissing extends AbstractDynamicMessage {

	public LaunchSpawn_WorldIsMissing() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__WORLD_IS_MISSING);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends LaunchSpawn_WorldIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de charger le spawn " + args[0] + ", il manque le nom du monde";
		}
	}

	private static class English extends LaunchSpawn_WorldIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot launch spawn " + args[0] + ", the world's name is missing";
		}
	}
}
