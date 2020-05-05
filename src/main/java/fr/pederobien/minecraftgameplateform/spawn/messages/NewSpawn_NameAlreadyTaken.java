package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewSpawn_NameAlreadyTaken extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public NewSpawn_NameAlreadyTaken() {
		super(ESpawnMessageCode.NEW_SPAWN__NAME_ALREADY_TAKEN);
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
