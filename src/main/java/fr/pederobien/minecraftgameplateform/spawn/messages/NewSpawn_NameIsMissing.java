package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewSpawn_NameIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NewSpawn_NameIsMissing(String message) {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_IS_MISSING, message);
	}

	private static class French extends NewSpawn_NameIsMissing {
		public French() {
			super("Impossible de créer un nouveau spawn, il manque le nom");
		}
	}

	private static class English extends NewSpawn_NameIsMissing {
		public English() {
			super("Cannot create a new spawn, the name is missing");
		}
	}
}
