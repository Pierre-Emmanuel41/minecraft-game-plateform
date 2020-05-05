package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListSpawn_OneElement extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
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
