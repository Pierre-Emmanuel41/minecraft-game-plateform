package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ListSpawn_NoElement extends AbstractMessage {
	/**
	 * Message in French explains there is no existing spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains there is no existing spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_NoElement() {
		super(ESpawnMessageCode.LIST_SPAWN__NO_ELEMENT);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends ListSpawn_NoElement {
		@Override
		public String getMessage(String... args) {
			return "Il n’existe aucun spawn";
		}
	}

	private static class English extends ListSpawn_NoElement {
		@Override
		public String getMessage(String... args) {
			return "No existing spawn";
		}
	}
}
