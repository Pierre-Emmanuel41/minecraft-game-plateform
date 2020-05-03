package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ExtractSpawn_SpawnExtracted extends AbstractDynamicMessage {

	public ExtractSpawn_SpawnExtracted() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
