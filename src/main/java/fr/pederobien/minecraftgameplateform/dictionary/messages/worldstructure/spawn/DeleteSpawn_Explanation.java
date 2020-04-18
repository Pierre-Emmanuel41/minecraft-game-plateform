package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class DeleteSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "delete" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "delete" do.
	 */
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
