package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class ExtractSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explain what does the command "extract" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explain what does the command "extract" do.
	 */
	public static final IMessage ENGLISH = new English();

	public ExtractSpawn_Explanation(String message) {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION, message);
	}

	private static class French extends DimensionSpawn_Explanation {
		public French() {
			super("Pour extraire du monde les blocs du spawn");
		}
	}

	private static class English extends DimensionSpawn_Explanation {
		public English() {
			super("to extract from the world spawn's blocks");
		}
	}
}
