package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NewBorder_Explanation(String message) {
		super(EBorderMessageCode.NEW_BORDER__EXPLANATION, message);
	}

	private static class French extends NewBorder_Explanation {
		public French() {
			super("Pour définir une nouvelle configuration de bordure");
		}
	}

	private static class English extends NewBorder_Explanation {
		public English() {
			super("To create a new border configuration");
		}
	}
}
