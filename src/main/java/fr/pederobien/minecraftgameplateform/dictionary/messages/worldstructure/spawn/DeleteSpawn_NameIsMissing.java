package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class DeleteSpawn_NameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the name is missing to delete a spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the name is missing to delete a spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_NameIsMissing(String message) {
		super(ESpawnMessageCode.DELETE_SPAWN__NAME_IS_MISSING, message);
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
