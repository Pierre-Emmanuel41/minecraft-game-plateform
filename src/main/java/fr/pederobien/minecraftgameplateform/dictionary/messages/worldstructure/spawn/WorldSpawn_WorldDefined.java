package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class WorldSpawn_WorldDefined extends AbstractMessage {
	/**
	 * Message in French when the spawn's world has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the spawn's world has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_WorldDefined() {
		super(ESpawnMessageCode.WORLD_SPAWN__WORLD_DEFINED);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "Le monde du spawn " + args[0] + " est le " + args[1];
		}
	}

	private static class English extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " spawn's world is " + args[1];
		}
	}
}
