package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CurrentSpawn_OnCurrent extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public CurrentSpawn_OnCurrent() {
		super(ESpawnMessageCode.CURRENT_SPAWN__ON_CURRENT);
	}

	private static class French extends CurrentSpawn_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Caractéristiques du spawn courant :\n" + args[0];
		}
	}

	private static class English extends CurrentSpawn_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Current spawn's characteristics :\n" + args[0];
		}
	}
}
