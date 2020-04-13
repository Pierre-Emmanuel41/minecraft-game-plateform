package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ExtractSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explain what does the command "extract" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explain what does the command "extract" do.
	 */
	public static final IMessage ENGLISH = new English();

	public ExtractSpawn_Explanation() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION);
	}

	private static class French extends ExtractSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour extraire du monde les blocs du spawn";
		}
	}

	private static class English extends ExtractSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "to extract from the world the spawn blocks";
		}
	}
}
