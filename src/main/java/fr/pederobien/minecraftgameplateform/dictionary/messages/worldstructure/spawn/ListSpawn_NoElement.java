package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class ListSpawn_NoElement extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains there is no existing spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains there is no existing spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public ListSpawn_NoElement(String message) {
		super(ESpawnMessageCode.LIST_SPAWN__NO_ELEMENT, message);
	}

	private static class French extends ListSpawn_NoElement {
		public French() {
			super("Il n’existe aucun spawn");
		}
	}

	private static class English extends ListSpawn_NoElement {
		public English() {
			super("No existing spawn");
		}
	}
}
