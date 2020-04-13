package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class WorldSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "world" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "world" do.
	 */
	public static final IMessage ENGLISH = new English();

	public WorldSpawn_Explanation() {
		super(ESpawnMessageCode.WORLD_SPAWN__EXPLANATION);
	}

	private static class French extends WorldSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour définir le monde dans lequel le spawn est chargé";
		}
	}

	private static class English extends WorldSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To set the world in which the spawn is launched";
		}
	}
}
