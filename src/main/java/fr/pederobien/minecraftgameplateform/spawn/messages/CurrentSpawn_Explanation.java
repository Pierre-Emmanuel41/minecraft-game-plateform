package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CurrentSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CurrentSpawn_Explanation(String message) {
		super(ESpawnMessageCode.CURRENT_SPAWN__EXPLANATION, message);
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
