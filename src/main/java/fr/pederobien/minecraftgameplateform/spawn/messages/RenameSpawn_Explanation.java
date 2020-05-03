package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RenameSpawn_Explanation extends AbstractNotDynamicMessage {

	public RenameSpawn_Explanation(String message) {
		super(ESpawnMessageCode.RENAME_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
