package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CurrentSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "current" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "current" do.
	 */
	public static final IMessage ENGLISH = new English();

	public CurrentSpawn_Explanation() {
		super(ESpawnMessageCode.CURRENT_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends CurrentSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour afficher les caractéristiques du spawn courant";
		}
	}

	private static class English extends CurrentSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To display current spawn’s characteristics";
		}
	}
}
