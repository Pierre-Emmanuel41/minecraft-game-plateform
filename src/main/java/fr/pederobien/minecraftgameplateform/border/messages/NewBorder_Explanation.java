package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

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
