package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class FinalBorderDiameter_OnTabComplete extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public FinalBorderDiameter_OnTabComplete(String message) {
		super(EBorderMessageCode.FINAL_BORDER_DIAMETER__ON_TAB_COMPLETE, message);
	}

	private static class French extends FinalBorderDiameter_OnTabComplete {
		public French() {
			super("<diamètre final>");
		}
	}

	private static class English extends FinalBorderDiameter_OnTabComplete {
		public English() {
			super("<final diameter>");
		}
	}
}
