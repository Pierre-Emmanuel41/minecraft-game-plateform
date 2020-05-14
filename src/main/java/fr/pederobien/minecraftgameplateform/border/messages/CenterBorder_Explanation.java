package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CenterBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
