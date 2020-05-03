package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewSpawn_SpawnCreated extends AbstractDynamicMessage {

	public NewSpawn_SpawnCreated() {
		super(ESpawnMessageCode.NEW_SPAWN__SPAWN_CREATED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends NewSpawn_SpawnCreated {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " créé";
		}
	}

	private static class English extends NewSpawn_SpawnCreated {
		@Override
		public String getMessage(String... args) {
			return "Spawn " + args[0] + " created";
		}
	}
}
