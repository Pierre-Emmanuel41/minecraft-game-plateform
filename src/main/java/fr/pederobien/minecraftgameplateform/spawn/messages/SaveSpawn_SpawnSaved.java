package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SaveSpawn_SpawnSaved extends AbstractDynamicMessage {

	public SaveSpawn_SpawnSaved() {
		super(ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " sauvegardé";
		}
	}

	private static class English extends SaveSpawn_SpawnSaved {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " saved";
		}
	}
}
