package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CurrentSpawn_Explanation extends AbstractNotDynamicMessage {

	public CurrentSpawn_Explanation(String message) {
		super(ESpawnMessageCode.CURRENT_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends CurrentSpawn_Explanation {
		public French() {
			super("Pour afficher les caractéristiques du spawn courant");
		}
	}

	private static class English extends CurrentSpawn_Explanation {
		public English() {
			super("To display current spawn’s characteristics");
		}
	}
}
