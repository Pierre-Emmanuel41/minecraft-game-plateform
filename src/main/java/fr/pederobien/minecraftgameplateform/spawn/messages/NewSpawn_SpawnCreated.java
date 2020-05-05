package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewSpawn_SpawnCreated extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public NewSpawn_SpawnCreated() {
		super(ESpawnMessageCode.NEW_SPAWN__SPAWN_CREATED);
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
