package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class InitialBorderDiameter_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public InitialBorderDiameter_Explanation(String message) {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__EXPLANATION, message);
	}

	private static class French extends InitialBorderDiameter_Explanation {
		public French() {
			super("Pour définir le diamètre initial de la bordure");
		}
	}

	private static class English extends InitialBorderDiameter_Explanation {
		public English() {
			super("To set the initial border diameter");
		}
	}
}
