package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class FinalBorderDiameter_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public FinalBorderDiameter_Explanation(String message) {
		super(EBorderMessageCode.FINAL_BORDER_DIAMETER__EXPLANATION, message);
	}

	private static class French extends FinalBorderDiameter_Explanation {
		public French() {
			super("Pour définir le diamètre final de la bordure");
		}
	}

	private static class English extends FinalBorderDiameter_Explanation {
		public English() {
			super("To set the final border diameter");
		}
	}
}
