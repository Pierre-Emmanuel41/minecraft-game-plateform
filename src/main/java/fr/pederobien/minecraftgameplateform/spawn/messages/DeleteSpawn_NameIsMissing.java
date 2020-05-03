package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DeleteSpawn_NameIsMissing extends AbstractNotDynamicMessage {

	public DeleteSpawn_NameIsMissing(String message) {
		super(ESpawnMessageCode.DELETE_SPAWN__NAME_IS_MISSING, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends DeleteSpawn_NameIsMissing {
		public French() {
			super("Impossible de supprimer un spawn, il manque le nom");
		}
	}

	private static class English extends DeleteSpawn_NameIsMissing {
		public English() {
			super("Cannot delete a spawn, the name is missing");
		}
	}
}
