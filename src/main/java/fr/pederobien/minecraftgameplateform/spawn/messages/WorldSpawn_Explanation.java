package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class WorldSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_Explanation(String message) {
		super(ESpawnMessageCode.WORLD_SPAWN__EXPLANATION, message);
	}

	private static class French extends WorldSpawn_Explanation {
		public French() {
			super("Pour définir le monde dans lequel le spawn est chargé");
		}
	}

	private static class English extends WorldSpawn_Explanation {
		public English() {
			super("To set the world in which the spawn is launched");
		}
	}
}
