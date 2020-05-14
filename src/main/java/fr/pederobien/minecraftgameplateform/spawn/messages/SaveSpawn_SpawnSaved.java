package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SaveSpawn_SpawnSaved extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SaveSpawn_SpawnSaved() {
		super(ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED);
	}

	private static class French extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " sauvegard�";
		}
	}

	private static class English extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " saved";
		}
	}
}
