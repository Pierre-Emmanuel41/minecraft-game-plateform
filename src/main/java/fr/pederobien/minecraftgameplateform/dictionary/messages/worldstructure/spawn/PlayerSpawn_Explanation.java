package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class PlayerSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "playerspawn" does.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "playerspawn" does.
	 */
	public static final IMessage ENGLISH = new English();

	public PlayerSpawn_Explanation() {
		super(ESpawnMessageCode.PLAYER_SPAWN__EXPLANATION);
	}

	private static class French extends PlayerSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour définir le bloc au dessus duquel les joueurs apparaîssent dans le monde";
		}
	}

	private static class English extends PlayerSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "to define the block above which players will spawn in the world";
		}
	}
}
