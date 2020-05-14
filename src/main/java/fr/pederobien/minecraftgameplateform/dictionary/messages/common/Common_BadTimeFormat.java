package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadTimeFormat extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_BadTimeFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_TIME_FORMAT, message);
	}

	private static class French extends Common_BadTimeFormat {
		public French() {
			super("Mauvais format, le temps doit respecter le schéma hh:mm:ss");
		}
	}

	private static class English extends Common_BadTimeFormat {
		public English() {
			super("Bad format, the time must respect the schema hh:mm:ss");
		}
	}
}
