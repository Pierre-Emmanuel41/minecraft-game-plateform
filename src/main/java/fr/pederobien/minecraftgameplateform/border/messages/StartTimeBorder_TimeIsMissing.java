package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class StartTimeBorder_TimeIsMissing extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public StartTimeBorder_TimeIsMissing(String message) {
		super(EBorderMessageCode.START_TIME_BORDER__TIME_IS_MISSING, message);
	}

	private static class French extends StartTimeBorder_TimeIsMissing {
		public French() {
			super("Impossible de définir le temps au bout duquel la bordure se déplace, il manque le temps");
		}
	}

	private static class English extends StartTimeBorder_TimeIsMissing {
		public English() {
			super("Cannot set the time after which the border moves, the time is missing");
		}
	}
}
