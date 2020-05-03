package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewSpawn_NameIsMissing extends AbstractNotDynamicMessage {

	public NewSpawn_NameIsMissing(String message) {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_IS_MISSING, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
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
