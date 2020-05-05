package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Border_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Border_Explanation(String message) {
		super(EBorderMessageCode.BORDER__EXPLANATION, message);
	}

	private static class French extends Border_Explanation {
		public French() {
			super("Pour configurer une bordure");
		}
	}

	private static class English extends Border_Explanation {
		public English() {
			super("To configure a border");
		}
	}
}
