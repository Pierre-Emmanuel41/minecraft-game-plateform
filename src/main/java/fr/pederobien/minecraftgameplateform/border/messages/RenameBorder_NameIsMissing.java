package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameBorder_NameIsMissing extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameBorder_NameIsMissing() {
		super(EBorderMessageCode.RENAME_BORDER__NAME_IS_MISSING);
	}

	private static class French extends RenameBorder_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer la bordure " + args[0] + ", il manque le nom";
		}
	}

	private static class English extends RenameBorder_NameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename border " + args[0] + ", the name is missing";
		}
	}
}
