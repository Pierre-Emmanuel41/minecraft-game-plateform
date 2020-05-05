package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ListSpawn_NoElement extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ListSpawn_NoElement(String message) {
		super(ESpawnMessageCode.LIST_SPAWN__NO_ELEMENT, message);
	}

	private static class French extends ListSpawn_NoElement {
		public French() {
			super("Il n�existe aucun spawn");
		}
	}

	private static class English extends ListSpawn_NoElement {
		public English() {
			super("No existing spawn");
		}
	}
}
