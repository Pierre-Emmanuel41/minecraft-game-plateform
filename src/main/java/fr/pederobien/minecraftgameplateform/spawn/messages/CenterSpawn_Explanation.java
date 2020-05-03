package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CenterSpawn_Explanation extends AbstractNotDynamicMessage {

	public CenterSpawn_Explanation(String message) {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends CenterSpawn_Explanation {
		public French() {
			super("Pour définir le centre du spawn");
		}
	}

	private static class English extends CenterSpawn_Explanation {
		public English() {
			super("To set spawn's center");
		}
	}
}
