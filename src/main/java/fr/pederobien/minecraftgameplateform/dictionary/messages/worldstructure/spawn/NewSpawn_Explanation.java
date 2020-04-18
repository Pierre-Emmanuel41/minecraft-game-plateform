package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class NewSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "new" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "new" do.
	 */
	public static final IMessage ENGLISH = new English();

	public NewSpawn_Explanation(String message) {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION, message);
	}

	private static class French extends NewSpawn_Explanation {
		public French() {
			super("Pour créer un nouveau spawn");
		}
	}

	private static class English extends NewSpawn_Explanation {
		public English() {
			super("To create a new spawn");
		}
	}
}
