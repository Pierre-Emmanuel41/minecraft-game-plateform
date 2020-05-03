package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewSpawn_NameAlreadyTaken extends AbstractDynamicMessage {

	public NewSpawn_NameAlreadyTaken() {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_ALREADY_TAKEN);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends NewSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Un spawn " + args[0] + " existe déjà";
		}
	}

	private static class English extends NewSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "A spawn " + args[0] + " already exists";
		}
	}
}
