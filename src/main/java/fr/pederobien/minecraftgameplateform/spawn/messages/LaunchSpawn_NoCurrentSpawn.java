package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LaunchSpawn_NoCurrentSpawn extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_NoCurrentSpawn(String message) {
		super(ESpawnMessageCode.LAUNCH_SPAWN__NO_CURRENT_SPAWN, message);
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
