package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RenameSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "rename" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "rename" do.
	 */
	public static final IMessage ENGLISH = new English();

	public RenameSpawn_Explanation() {
		super(ESpawnMessageCode.RENAME_SPAWN__EXPLANATION);
	}

	private static class French extends RenameSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour renommer un spawn";
		}
	}

	private static class English extends RenameSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To rename a spawn";
		}
	}
}
