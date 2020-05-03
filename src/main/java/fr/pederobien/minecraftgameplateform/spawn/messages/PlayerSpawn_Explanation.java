package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class PlayerSpawn_Explanation extends AbstractNotDynamicMessage {

	public PlayerSpawn_Explanation(String message) {
		super(ESpawnMessageCode.PLAYER_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
