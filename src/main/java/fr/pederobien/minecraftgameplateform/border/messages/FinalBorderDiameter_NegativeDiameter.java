package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class FinalBorderDiameter_NegativeDiameter extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public FinalBorderDiameter_NegativeDiameter() {
		super(EBorderMessageCode.FINAL_BORDER_DIAMETER__NEGATIVE_DIAMETER);
	}

	public static class French extends FinalBorderDiameter_NegativeDiameter {
		@Override
		public String getMessage(String... args) {
			return "Impossible de définir le diamètre final de la bordure " + args[0] + ", le diamètre est négatif";
		}
	}

	public static class English extends FinalBorderDiameter_NegativeDiameter {
		@Override
		public String getMessage(String... args) {
			return "Cannot set the final diameter of border " + args[0] + ", the diameter is negative";
		}
	}
}
