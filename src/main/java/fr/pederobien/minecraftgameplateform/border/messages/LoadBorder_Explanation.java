package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LoadBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public LoadBorder_Explanation(String message) {
		super(EBorderMessageCode.LOAD_BORDER__EXPLANATION, message);
	}

	private static class French extends LoadBorder_Explanation {
		public French() {
			super("Pour charger une configuration de bordure");
		}
	}

	private static class English extends LoadBorder_Explanation {
		public English() {
			super("To load a border configuration");
		}
	}
}
