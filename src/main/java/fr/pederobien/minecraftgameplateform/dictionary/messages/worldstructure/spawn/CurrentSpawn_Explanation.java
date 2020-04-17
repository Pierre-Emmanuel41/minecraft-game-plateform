package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CurrentSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "current" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "current" do.
	 */
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
