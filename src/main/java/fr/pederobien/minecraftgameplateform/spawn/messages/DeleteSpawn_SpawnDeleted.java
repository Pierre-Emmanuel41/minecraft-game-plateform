package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteSpawn_SpawnDeleted extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public DeleteSpawn_SpawnDeleted() {
		super(ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED);
	}

	private static class French extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(Object... args) {
			return "Le fichier du spawn " + args[0] + " a été supprimé";
		}
	}

	private static class English extends DeleteSpawn_SpawnDeleted {
		@Override
		public String getMessage(Object... args) {
			return "The " + args[0] + " spawn's file has been deleted";
		}
	}
}
