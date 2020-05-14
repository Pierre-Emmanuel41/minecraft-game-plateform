package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpawnParent_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SpawnParent_Explanation(String message) {
		super(ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, message);
	}

	private static class French extends SpawnParent_Explanation {
		public French() {
			super("Pour configurer un spawn");
		}
	}

	private static class English extends SpawnParent_Explanation {
		public English() {
			super("To configure a spawn");
		}
	}
}
