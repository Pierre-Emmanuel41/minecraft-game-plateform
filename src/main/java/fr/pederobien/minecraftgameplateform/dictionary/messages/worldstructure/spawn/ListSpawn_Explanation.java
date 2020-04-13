package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ListSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "list" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "list" do.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_Explanation() {
		super(ESpawnMessageCode.LIST_SPAWN__EXPLANATION);
	}

	private static class French extends ListSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour afficher le nom des spawns existants";
		}
	}

	private static class English extends ListSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To display existing spawn's names";
		}
	}
}
