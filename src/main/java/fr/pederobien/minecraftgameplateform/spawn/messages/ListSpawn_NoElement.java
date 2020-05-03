package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ListSpawn_NoElement extends AbstractNotDynamicMessage {

	public ListSpawn_NoElement(String message) {
		super(ESpawnMessageCode.LIST_SPAWN__NO_ELEMENT, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
