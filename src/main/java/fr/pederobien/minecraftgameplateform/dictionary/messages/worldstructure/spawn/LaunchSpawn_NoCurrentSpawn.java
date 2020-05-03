package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LaunchSpawn_NoCurrentSpawn extends AbstractNotDynamicMessage {

	public LaunchSpawn_NoCurrentSpawn(String message) {
		super(ESpawnMessageCode.LAUNCH_SPAWN__NO_CURRENT_SPAWN, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends LaunchSpawn_NoCurrentSpawn {
		public French() {
			super("Il n'y a pas de spawn courant");
		}
	}

	private static class English extends LaunchSpawn_NoCurrentSpawn {
		public English() {
			super("There is no current spawn");
		}
	}
}
