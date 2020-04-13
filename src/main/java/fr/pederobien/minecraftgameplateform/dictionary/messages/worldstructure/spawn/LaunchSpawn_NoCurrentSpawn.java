package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class LaunchSpawn_NoCurrentSpawn extends AbstractMessage {
	/**
	 * Message in French when launching the not defined current spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when launching the not defined current spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public LaunchSpawn_NoCurrentSpawn() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__NO_CURRENT_SPAWN);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends LaunchSpawn_NoCurrentSpawn {
		@Override
		public String getMessage(String... args) {
			return "Il n'y a pas de spawn courant";
		}
	}

	private static class English extends LaunchSpawn_NoCurrentSpawn {
		@Override
		public String getMessage(String... args) {
			return "There is no current spawn";
		}
	}
}
