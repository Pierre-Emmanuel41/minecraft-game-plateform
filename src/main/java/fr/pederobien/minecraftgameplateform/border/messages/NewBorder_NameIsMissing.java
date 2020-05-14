package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewBorder_NameIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NewBorder_NameIsMissing(String message) {
		super(EBorderMessageCode.NEW_BORDER__NAME_IS_MISSING, message);
	}

	private static class French extends NewBorder_NameIsMissing {
		public French() {
			super("Impossible de définir une nouvelle bordure, il manque le nom");
		}
	}

	private static class English extends NewBorder_NameIsMissing {
		public English() {
			super("Cannot define a new border, the name is missing");
		}
	}
}
