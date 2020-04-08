package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class SaveSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "save" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "save" do.
	 */
	public static final IMessage ENGLISH = new English();

	public SaveSpawn_Explanation() {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends SaveSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour sauvegarder le spawn courant";
		}
	}

	private static class English extends SaveSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To save the current spawn";
		}
	}
}
