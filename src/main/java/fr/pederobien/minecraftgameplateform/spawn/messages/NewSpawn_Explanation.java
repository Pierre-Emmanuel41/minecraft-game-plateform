package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewSpawn_Explanation extends AbstractNotDynamicMessage {

	public NewSpawn_Explanation(String message) {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
