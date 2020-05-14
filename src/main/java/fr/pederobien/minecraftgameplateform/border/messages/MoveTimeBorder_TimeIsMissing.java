package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class MoveTimeBorder_TimeIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public MoveTimeBorder_TimeIsMissing(String message) {
		super(EBorderMessageCode.MOVE_TIME_BORDER__TIME_IS_MISSING, message);
	}

	private static class French extends MoveTimeBorder_TimeIsMissing {
		public French() {
			super("Impossible de définir le temps de déplacement de la bordure, il manque le temps");
		}
	}

	private static class English extends MoveTimeBorder_TimeIsMissing {
		public English() {
			super("Cannot set the time to move the border, the time is missing");
		}
	}
}
