package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class MoveTimeBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public MoveTimeBorder_Explanation(String message) {
		super(EBorderMessageCode.MOVE_TIME_BORDER__EXPLANATION, message);
	}

	private static class French extends MoveTimeBorder_Explanation {
		public French() {
			super("Pour d�finir le temps que met la bordure pour se d�placer de son diam�tre initial � son diam�tre final");
		}
	}

	private static class English extends MoveTimeBorder_Explanation {
		public English() {
			super("To set the time it takes to move the border from its initial diameter to its final diameter");
		}
	}
}
