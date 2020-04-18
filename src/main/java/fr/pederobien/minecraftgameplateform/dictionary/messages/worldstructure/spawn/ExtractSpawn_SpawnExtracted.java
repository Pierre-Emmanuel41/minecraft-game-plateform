package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class ExtractSpawn_SpawnExtracted extends AbstractDynamicMessage {
	/**
	 * Message in French when blocks associated to a spawn have been correctly extracted.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when blocks associated to a spawn have been correctly extracted.
	 */
	public static final IMessage ENGLISH = new English();

	public ExtractSpawn_SpawnExtracted() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED);
	}

	private static class French extends ExtractSpawn_SpawnExtracted {
		@Override
		public String getMessage(String... args) {
			return "Les blocks du spawn " + args[0] + " ont été extrait";
		}
	}

	private static class English extends ExtractSpawn_SpawnExtracted {
		@Override
		public String getMessage(String... args) {
			return args[0] + " spawn's blocks have been extracted";
		}
	}
}
