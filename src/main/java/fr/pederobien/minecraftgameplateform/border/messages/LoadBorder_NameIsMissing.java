package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LoadBorder_NameIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public LoadBorder_NameIsMissing(String message) {
		super(EBorderMessageCode.LOAD_BORDER__NAME_IS_MISSING, message);
	}

	private static class French extends LoadBorder_NameIsMissing {
		public French() {
			super("Impossible de charger une configuration de bordure, il manque le nom");
		}
	}

	private static class English extends LoadBorder_NameIsMissing {
		public English() {
			super("Cannot load a border configuration, the name is missing");
		}
	}
}
