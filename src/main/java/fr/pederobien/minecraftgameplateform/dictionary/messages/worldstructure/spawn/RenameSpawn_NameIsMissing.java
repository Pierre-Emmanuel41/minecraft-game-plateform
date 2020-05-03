package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameSpawn_NameIsMissing extends AbstractDynamicMessage {

	public RenameSpawn_NameIsMissing() {
		super(ESpawnMessageCode.RENAME_SPAWN__NAME_IS_MISSING);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends RenameSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer le spawn " + args[0] + ", il manque le nom";
		}
	}

	private static class English extends RenameSpawn_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename the spawn " + args[0] + ", the name is missing";
		}
	}
}
