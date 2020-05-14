package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class StartTimeBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public StartTimeBorder_Explanation(String message) {
		super(EBorderMessageCode.START_TIME_BORDER__EXPLANATION, message);
	}

	private static class French extends StartTimeBorder_Explanation {
		public French() {
			super("Pour d�finir le temps � partir duquel la bordure se d�place de son diam�tre initial � son diam�tre final");
		}
	}

	private static class English extends StartTimeBorder_Explanation {
		public English() {
			super("To set the time after which the border moves from its initial diameter to its final diameter");
		}
	}
}
