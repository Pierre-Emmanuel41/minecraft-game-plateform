package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class FinalBorderDiameter_DiameterIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public FinalBorderDiameter_DiameterIsMissing() {
		super(EBorderMessageCode.FINAL_BORDER_DIAMETER__DIAMETER_IS_MISSING);
	}

	private static class French extends FinalBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de d�finir le diam�tre final de la bordure " + args[0] + ", il manque le diam�tre";
		}
	}

	private static class English extends FinalBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot set the final diameter of border " + args[0] + ", the diameter is missing";
		}
	}
}