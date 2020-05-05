package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameSpawn_NameIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public RenameSpawn_NameIsMissing() {
		super(ESpawnMessageCode.RENAME_SPAWN__NAME_IS_MISSING);
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