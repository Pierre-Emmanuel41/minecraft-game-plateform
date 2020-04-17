package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RenameSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "rename" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "rename" do.
	 */
	public static final IMessage ENGLISH = new English();

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
