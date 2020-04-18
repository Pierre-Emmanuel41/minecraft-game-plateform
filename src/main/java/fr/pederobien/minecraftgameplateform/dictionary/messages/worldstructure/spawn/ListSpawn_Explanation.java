package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class ListSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "list" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "list" do.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_Explanation(String message) {
		super(ESpawnMessageCode.LIST_SPAWN__EXPLANATION, message);
	}

	private static class French extends ListSpawn_Explanation {
		public French() {
			super("Pour afficher le nom des spawns existants");
		}
	}

	private static class English extends ListSpawn_Explanation {
		public English() {
			super("To display existing spawn's names");
		}
	}
}
