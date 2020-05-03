package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpawnParentExplanation extends AbstractNotDynamicMessage {

	public SpawnParentExplanation(String message) {
		super(ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends SpawnParentExplanation {
		public French() {
			super("Pour configurer un spawn");
		}
	}

	private static class English extends SpawnParentExplanation {
		public English() {
			super("To configure a spawn");
		}
	}
}
