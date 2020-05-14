package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RenameBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameBorder_Explanation(String message) {
		super(EBorderMessageCode.RENAME_BORDER__EXPLANATION, message);
	}

	private static class French extends RenameBorder_Explanation {
		public French() {
			super("Pour renommer une bordure");
		}
	}

	private static class English extends RenameBorder_Explanation {
		public English() {
			super("To rename a border");
		}
	}
}
