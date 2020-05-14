package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RemoveSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RemoveSpawn_Explanation(String message) {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION, message);
	}

	private static class French extends RemoveSpawn_Explanation {
		public French() {
			super("Pour enlever le spawn du monde");
		}
	}

	private static class English extends RemoveSpawn_Explanation {
		public English() {
			super("To remove the spawn from the world");
		}
	}
}
