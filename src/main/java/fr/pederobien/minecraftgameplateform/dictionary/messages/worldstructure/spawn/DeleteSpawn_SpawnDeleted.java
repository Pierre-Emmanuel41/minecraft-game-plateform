package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class DeleteSpawn_SpawnDeleted extends AbstractDynamicMessage {
	/**
	 * Message in French when the file associated to the given spawn name has been correctly deleted.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the file associated to the given spawn name has been correctly deleted.
	 */
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_SpawnDeleted() {
		super(ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED);
	}

	private static class French extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(String... args) {
			return "Le fichier du spawn " + args[0] + " a été supprimé";
		}
	}

	private static class English extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " spawn's file has been deleted";
		}
	}
}
