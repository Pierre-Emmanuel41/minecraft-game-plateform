package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpeedBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SpeedBorder_Explanation(String message) {
		super(EBorderMessageCode.SPEED_BORDER__EXPLANATION, message);
	}

	private static class French extends SpeedBorder_Explanation {
		public French() {
			super("pour définir la vitesse de déplacement de la bordure");
		}
	}

	private static class English extends SpeedBorder_Explanation {
		public English() {
			super("To set the border’s speed");
		}
	}
}
