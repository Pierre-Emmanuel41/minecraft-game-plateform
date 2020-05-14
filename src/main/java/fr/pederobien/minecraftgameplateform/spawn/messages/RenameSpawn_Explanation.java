package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RenameSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameSpawn_Explanation(String message) {
		super(ESpawnMessageCode.RENAME_SPAWN__EXPLANATION, message);
	}

	private static class French extends RenameSpawn_Explanation {
		public French() {
			super("Pour renommer un spawn");
		}
	}

	private static class English extends RenameSpawn_Explanation {
		public English() {
			super("To rename a spawn");
		}
	}
}
