package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NewSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "new" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "new" do.
	 */
	public static final IMessage ENGLISH = new English();

	public NewSpawn_Explanation() {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION);
	}

	private static class French extends NewSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour créer un nouveau spawn";
		}
	}

	private static class English extends NewSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To create a new spawn";
		}
	}
}
