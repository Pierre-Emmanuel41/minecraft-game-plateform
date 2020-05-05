package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ExtractSpawn_SpawnExtracted extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ExtractSpawn_SpawnExtracted() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED);
	}

	private static class French extends ExtractSpawn_SpawnExtracted {
		@Override
		public String getMessage(String... args) {
			return "Les blocks du spawn " + args[0] + " ont �t� extrait";
		}
	}

	private static class English extends ExtractSpawn_SpawnExtracted {
		@Override
		public String getMessage(String... args) {
			return args[0] + " spawn's blocks have been extracted";
		}
	}
}