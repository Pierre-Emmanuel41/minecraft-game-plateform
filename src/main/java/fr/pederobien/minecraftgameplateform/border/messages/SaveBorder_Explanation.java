package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SaveBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SaveBorder_Explanation(String message) {
		super(EBorderMessageCode.SAVE_BORDER__EXPLANATION, message);
	}

	private static class French extends SaveBorder_Explanation {
		public French() {
			super("Pour sauvegarder la bordure courante");
		}
	}

	private static class English extends SaveBorder_Explanation {
		public English() {
			super("To save the current border");
		}
	}
}
