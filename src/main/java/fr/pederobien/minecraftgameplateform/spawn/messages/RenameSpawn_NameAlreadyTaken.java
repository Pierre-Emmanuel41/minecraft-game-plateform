package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameSpawn_NameAlreadyTaken extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RenameSpawn_NameAlreadyTaken() {
		super(ESpawnMessageCode.RENAME_SPAWN__NAME_ALREADY_TAKEN);
	}

	private static class French extends RenameSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer le spawn " + args[0] + " en " + args[1] + ", un spawn du m�me nom existe d�j�";
		}
	}

	private static class English extends RenameSpawn_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename spawn " + args[0] + " as " + args[1] + ", a spawn with the same name already exist";
		}
	}
}
