package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class DeleteSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "delete" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "delete" do.
	 */
	public static final IMessage ENGLISH = new English();

	public DeleteSpawn_Explanation() {
		super(ESpawnMessageCode.DELETE_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends DeleteSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour supprimer le fichier d'un spawn";
		}
	}

	private static class English extends DeleteSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To delete a spawn's file";
		}
	}
}
