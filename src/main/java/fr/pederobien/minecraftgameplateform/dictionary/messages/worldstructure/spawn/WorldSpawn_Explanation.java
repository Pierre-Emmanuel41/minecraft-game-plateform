package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class WorldSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "world" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "world" do.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_Explanation(String message) {
		super(ESpawnMessageCode.WORLD_SPAWN__EXPLANATION, message);
	}

	private static class French extends WorldSpawn_Explanation {
		public French() {
			super("Pour définir le monde dans lequel le spawn est chargé");
		}
	}

	private static class English extends WorldSpawn_Explanation {
		public English() {
			super("To set the world in which the spawn is launched");
		}
	}
}
