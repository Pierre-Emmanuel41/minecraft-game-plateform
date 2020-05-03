package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DeleteSpawn_Explanation extends AbstractNotDynamicMessage {

	public DeleteSpawn_Explanation(String message) {
		super(ESpawnMessageCode.DELETE_SPAWN__EXPLANATION, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
