package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteSpawn_SpawnDeleted extends AbstractDynamicMessage {

	public DeleteSpawn_SpawnDeleted() {
		super(ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
