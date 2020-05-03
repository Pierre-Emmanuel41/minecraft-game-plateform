package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListSpawn_OneElement extends AbstractDynamicMessage {

	public ListSpawn_OneElement() {
		super(ESpawnMessageCode.LIST_SPAWN__ONE_ELEMENT);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
