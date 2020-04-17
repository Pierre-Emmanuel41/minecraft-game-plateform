package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class NewSpawn_NameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains the name is missing to create a new spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the name is missing to create a new spawn.
	 */
	public static final IMessage ENGLISH = new English();

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
