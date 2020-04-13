package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class PlayerSpawn_PlayerSpawnDefined extends AbstractMessage {
	/**
	 * Message in French when the player's spawn has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the player's spawn has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public PlayerSpawn_PlayerSpawnDefined() {
		super(ESpawnMessageCode.PLAYER_SPAWN__PLAYER_SPAWN_DEFINED);
	}

	private static class French extends PlayerSpawn_PlayerSpawnDefined {
		@Override
		public String getMessage(String... args) {
			return "Les joueurs apparaîtront en X=" + args[0] + " Y=" + args[1] + " Z=" + args[2];
		}
	}

	private static class English extends PlayerSpawn_PlayerSpawnDefined {
		@Override
		public String getMessage(String... args) {
			return "Players will spawn at X=" + args[0] + " Y=" + args[1] + " Z=" + args[2];
		}
	}
}
