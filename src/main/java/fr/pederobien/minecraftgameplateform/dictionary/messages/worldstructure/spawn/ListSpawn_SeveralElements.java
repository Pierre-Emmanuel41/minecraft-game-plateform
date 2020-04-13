package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ListSpawn_SeveralElements extends AbstractMessage {
	/**
	 * Message in French when there is several existing spawns.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when there is several existing spawns.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_SeveralElements() {
		super(ESpawnMessageCode.LIST_SPAWN__SEVERAL_ELEMENTS);
	}

	private static class French extends ListSpawn_SeveralElements {
		@Override
		public String getMessage(String... args) {
			return "Liste des spawns existants :\n" + args[0];
		}
	}

	private static class English extends ListSpawn_SeveralElements {
		@Override
		public String getMessage(String... args) {
			return "List of existing spawns :\n" + args[0];
		}
	}
}
