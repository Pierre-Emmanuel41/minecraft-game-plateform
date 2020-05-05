package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DeleteSpawn_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_Explanation(String message) {
		super(ESpawnMessageCode.DELETE_SPAWN__EXPLANATION, message);
	}

	private static class French extends DeleteSpawn_Explanation {
		public French() {
			super("Pour supprimer le fichier d'un spawn");
		}
	}

	private static class English extends DeleteSpawn_Explanation {
		public English() {
			super("To delete a spawn's file");
		}
	}
}
