package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class SaveSpawn_SpawnSaved extends AbstractDynamicMessage {
	/**
	 * Message in French when a spawn has been correctly saved.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when a spawn has been correctly saved.
	 */
	public static final IMessage ENGLISH = new English();

	public SaveSpawn_SpawnSaved() {
		super(ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED);
	}

	private static class French extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " sauvegardé";
		}
	}

	private static class English extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " saved";
		}
	}
}
