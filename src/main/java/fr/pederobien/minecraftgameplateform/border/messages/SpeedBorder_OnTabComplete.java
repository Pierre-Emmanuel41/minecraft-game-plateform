package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class SpeedBorder_OnTabComplete extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SpeedBorder_OnTabComplete(String message) {
		super(EBorderMessageCode.SPEED_BORDER__ON_TAB_COMPLETE, message);
	}

	private static class French extends SpeedBorder_OnTabComplete {
		public French() {
			super("<bloc/s>");
		}
	}

	private static class English extends SpeedBorder_OnTabComplete {
		public English() {
			super("<block/s>");
		}
	}
}
