package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CenterSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CenterSpawn_Explanation(String message) {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION, message);
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
