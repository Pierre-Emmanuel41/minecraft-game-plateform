package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpeedBorder_SpeedIsNegative extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SpeedBorder_SpeedIsNegative(String message) {
		super(EBorderMessageCode.SPEED_BORDER__SPEED_IS_NEGATIVE, message);
	}

	private static class French extends SpeedBorder_SpeedIsNegative {
		public French() {
			super("Impossible de définir la vitesse de la bordure, la vitesse doit être strictement positive");
		}
	}

	private static class English extends SpeedBorder_SpeedIsNegative {
		public English() {
			super("Cannot set the border's speed, the speed must be strictly positive");
		}
	}
}
