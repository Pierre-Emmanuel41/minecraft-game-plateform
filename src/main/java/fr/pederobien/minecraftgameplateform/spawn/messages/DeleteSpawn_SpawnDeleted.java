package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteSpawn_SpawnDeleted extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_SpawnDeleted() {
		super(ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED);
	}

	private static class French extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(String... args) {
			return "Le fichier du spawn " + args[0] + " a �t� supprim�";
		}
	}

	private static class English extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " spawn's file has been deleted";
		}
	}
}