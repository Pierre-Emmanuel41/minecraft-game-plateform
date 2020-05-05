package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ListSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
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