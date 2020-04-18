package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class DeleteSpawn_DidNotDelete extends AbstractDynamicMessage {
	/**
	 * Message in French when the deletion was not successful.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the deletion was not successful.
	 */
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_DidNotDelete() {
		super(ESpawnMessageCode.DELETE_SPAWN__DIT_NOT_DELETE);
	}

	private static class French extends DeleteSpawn_DidNotDelete {
		@Override
		public String getMessage(String... args) {
			return "La suppresion du fichier " + args[0] + " n'a pas pu s'effectuer correctement";
		}
	}

	private static class English extends DeleteSpawn_DidNotDelete {
		@Override
		public String getMessage(String... args) {
			return "The deletion of the file " + args[0] + " was not successful";
		}
	}
}
