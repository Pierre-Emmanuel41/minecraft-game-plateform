package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class PlayerSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public PlayerSpawn_Explanation(String message) {
		super(ESpawnMessageCode.PLAYER_SPAWN__EXPLANATION, message);
	}

	private static class French extends PlayerSpawn_Explanation {
		public French() {
			super("Pour d�finir le bloc au dessus duquel les joueurs appara�ssent dans le monde");
		}
	}

	private static class English extends PlayerSpawn_Explanation {
		public English() {
			super("to define the block above which players will spawn in the world");
		}
	}
}
