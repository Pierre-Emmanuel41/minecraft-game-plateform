package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class PlayerSpawn_PlayerSpawnDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
