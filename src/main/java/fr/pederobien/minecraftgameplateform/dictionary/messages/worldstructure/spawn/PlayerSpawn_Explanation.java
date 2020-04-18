package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class PlayerSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "playerspawn" does.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "playerspawn" does.
	 */
	public static final IMessage ENGLISH = new English();

	public PlayerSpawn_Explanation(String message) {
		super(ESpawnMessageCode.PLAYER_SPAWN__EXPLANATION, message);
	}

	private static class French extends PlayerSpawn_Explanation {
		public French() {
			super("Pour définir le bloc au dessus duquel les joueurs apparaîssent dans le monde");
		}
	}

	private static class English extends PlayerSpawn_Explanation {
		public English() {
			super("to define the block above which players will spawn in the world");
		}
	}
}
