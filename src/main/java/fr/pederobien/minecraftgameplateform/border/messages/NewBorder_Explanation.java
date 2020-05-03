package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class NewBorder_Explanation extends AbstractNotDynamicMessage {

	public NewBorder_Explanation(String message) {
		super(EBorderMessageCode.NEW_BORDER__EXPLANATION, message);
		EBorderMessages.FRENCH.add(new French());
		EBorderMessages.ENGLISH.add(new English());
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
