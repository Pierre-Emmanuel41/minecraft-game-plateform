package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListSpawn_SeveralElements extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
