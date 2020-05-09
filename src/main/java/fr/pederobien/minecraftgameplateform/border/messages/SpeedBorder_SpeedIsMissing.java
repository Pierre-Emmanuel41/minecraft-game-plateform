package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpeedBorder_SpeedIsMissing extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SpeedBorder_SpeedIsMissing(String message) {
		super(EBorderMessageCode.SPEED_BORDER__SPEED_IS_MISSING, message);
	}

	private static class French extends SpeedBorder_SpeedIsMissing {
		public French() {
			super("Impossible de définir la vitesse de la bordure, il manque la vitesse");
		}
	}

	private static class English extends SpeedBorder_SpeedIsMissing {
		public English() {
			super("Cannot set the border's speed, the speed is missing");
		}
	}
}
