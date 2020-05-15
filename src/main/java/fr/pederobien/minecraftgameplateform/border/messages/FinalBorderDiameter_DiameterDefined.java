package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class FinalBorderDiameter_DiameterDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public FinalBorderDiameter_DiameterDefined() {
		super(EBorderMessageCode.FINAL_BORDER_DIAMETER__DIAMETER_DEFINED);
	}

	private static class French extends FinalBorderDiameter_DiameterDefined {
		@Override
		public String getMessage(Object... args) {
			return "Le diamètre final de la bordure " + args[0] + " est de " + args[1] + " bloc(s)";
		}
	}

	private static class English extends FinalBorderDiameter_DiameterDefined {
		@Override
		public String getMessage(Object... args) {
			return "The final diameter of border " + args[0] + " is " + args[1] + " block(s)";
		}
	}
}
