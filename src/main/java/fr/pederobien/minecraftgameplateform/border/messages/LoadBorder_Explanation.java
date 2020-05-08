package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class LoadBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

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
