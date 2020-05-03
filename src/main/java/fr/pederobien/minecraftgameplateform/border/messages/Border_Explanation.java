package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Border_Explanation extends AbstractNotDynamicMessage {

	public Border_Explanation(String message) {
		super(EBorderMessageCode.BORDER__EXPLANATION, message);
		EBorderMessages.FRENCH.add(new French());
		EBorderMessages.ENGLISH.add(new English());
	}

	private static class French extends Border_Explanation {
		public French() {
			super("Pour définir une nouvelle configuration de bordure");
		}
	}

	private static class English extends Border_Explanation {
		public English() {
			super("To define a new border configuration");
		}
	}
}
