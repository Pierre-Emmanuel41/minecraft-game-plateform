package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CenterBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CenterBorder_Explanation(String message) {
		super(EBorderMessageCode.CENTER_BORDER__EXPLANATION, message);
	}

	private static class French extends CenterBorder_Explanation {
		public French() {
			super("Pour définir le centre de la bordure");
		}
	}

	private static class English extends CenterBorder_Explanation {
		public English() {
			super("to set the border's center");
		}
	}
}
