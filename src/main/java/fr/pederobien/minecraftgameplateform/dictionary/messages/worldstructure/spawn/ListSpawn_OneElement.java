package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ListSpawn_OneElement extends AbstractMessage {
	/**
	 * Message in French when there is on existing spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when there is on existing spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_OneElement() {
		super(ESpawnMessageCode.LIST_SPAWN__ONE_ELEMENT);
	}

	private static class French extends ListSpawn_OneElement {
		@Override
		public String getMessage(String... args) {
			return "Il existe un spawn : " + args[0];
		}
	}

	private static class English extends ListSpawn_OneElement {
		@Override
		public String getMessage(String... args) {
			return "One existing spawn : " + args[0];
		}
	}
}
