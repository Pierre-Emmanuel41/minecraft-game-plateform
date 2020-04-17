package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RemoveSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "remove" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "remove" do.
	 */
	public static final IMessage ENGLISH = new English();

	public RemoveSpawn_Explanation(String message) {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION, message);
	}

	private static class French extends RemoveSpawn_Explanation {
		public French() {
			super("Pour enlever le spawn du monde");
		}
	}

	private static class English extends RemoveSpawn_Explanation {
		public English() {
			super("To remove the spawn from the world");
		}
	}
}
