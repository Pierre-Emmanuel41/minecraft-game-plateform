package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class InitialBorderDiameter_OnTabComplete extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public InitialBorderDiameter_OnTabComplete(String message) {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__ON_TAB_COMPLETE, message);
	}

	private static class French extends InitialBorderDiameter_OnTabComplete {
		public French() {
			super("<diamètre initial>");
		}
	}

	private static class English extends InitialBorderDiameter_OnTabComplete {
		public English() {
			super("<initial diameter>");
		}
	}
}
