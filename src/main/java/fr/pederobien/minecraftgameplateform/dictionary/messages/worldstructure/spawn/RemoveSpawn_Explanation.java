package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RemoveSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "remove" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "remove" do.
	 */
	public static final IMessage ENGLISH = new English();

	public RemoveSpawn_Explanation() {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION);
	}

	private static class French extends RemoveSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour enlever le spawn du monde";
		}
	}

	private static class English extends RemoveSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To remove the spawn from the world";
		}
	}
}
