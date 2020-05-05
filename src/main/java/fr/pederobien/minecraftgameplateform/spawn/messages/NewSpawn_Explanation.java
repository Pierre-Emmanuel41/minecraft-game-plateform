package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public NewSpawn_Explanation(String message) {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION, message);
	}

	private static class French extends NewSpawn_Explanation {
		public French() {
			super("Pour cr�er un nouveau spawn");
		}
	}

	private static class English extends NewSpawn_Explanation {
		public English() {
			super("To create a new spawn");
		}
	}
}