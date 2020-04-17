package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class SaveSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "save" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "save" do.
	 */
	public static final IMessage ENGLISH = new English();

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
