package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ExtractSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ExtractSpawn_Explanation(String message) {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION, message);
	}

	private static class French extends ExtractSpawn_Explanation {
		public French() {
			super("Pour extraire du monde les blocs du spawn");
		}
	}

	private static class English extends ExtractSpawn_Explanation {
		public English() {
			super("to extract from the world spawn's blocks");
		}
	}
}
