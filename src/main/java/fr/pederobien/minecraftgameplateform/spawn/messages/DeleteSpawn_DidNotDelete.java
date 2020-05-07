package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteSpawn_DidNotDelete extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_DidNotDelete() {
		super(ESpawnMessageCode.DELETE_SPAWN__DIT_NOT_DELETE);
	}

	private static class French extends DeleteSpawn_DidNotDelete {
		@Override
		public String getMessage(String... args) {
			return "La suppresion du spawn " + args[0] + " n'a pas pu s'effectuer correctement";
		}
	}

	private static class English extends DeleteSpawn_DidNotDelete {
		@Override
		public String getMessage(String... args) {
			return "The deletion of spawn " + args[0] + " was not successful";
		}
	}
}
