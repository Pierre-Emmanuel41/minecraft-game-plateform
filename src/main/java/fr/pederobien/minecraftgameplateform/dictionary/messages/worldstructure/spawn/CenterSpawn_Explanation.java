package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CenterSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French to explain what does the command "center" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to explain what does the command "center" do.
	 */
	public static final IMessage ENGLISH = new English();

	public CenterSpawn_Explanation() {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION);
	}

	private static class French extends CenterSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour définir le centre du spawn";
		}
	}

	private static class English extends CenterSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To set the spawn's center";
		}
	}
}
