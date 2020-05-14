package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Common_BadDoubleFormat extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_BadDoubleFormat(String message) {
		super(ECommonMessageCode.COMMON_BAD_DOUBLE_FORMAT, message);
	}

	private static class French extends Common_BadDoubleFormat {
		public French() {
			super("Mauvais format, les arguments doivent être des doubles");
		}
	}

	private static class English extends Common_BadDoubleFormat {
		public English() {
			super("Bad format, arguments should be doubles");
		}
	}
}
