package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SaveSpawn_Explanation extends AbstractNotDynamicMessage {

	public SaveSpawn_Explanation(String message) {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends SaveSpawn_Explanation {
		public French() {
			super("Pour sauvegarder le spawn courant");
		}
	}

	private static class English extends SaveSpawn_Explanation {
		public English() {
			super("To save the current spawn");
		}
	}
}
