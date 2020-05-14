package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SaveSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SaveSpawn_Explanation(String message) {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION, message);
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
