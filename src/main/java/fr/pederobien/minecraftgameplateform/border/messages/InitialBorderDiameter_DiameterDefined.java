package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class InitialBorderDiameter_DiameterDefined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public InitialBorderDiameter_DiameterDefined() {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__DIAMETER_DEFINED);
	}

	private static class French extends InitialBorderDiameter_DiameterDefined {
		@Override
		public String getMessage(String... args) {
			return "Le diamètre initial de la bordure " + args[0] + " est de " + args[1] + " bloc(s)";
		}
	}

	private static class English extends InitialBorderDiameter_DiameterDefined {
		@Override
		public String getMessage(String... args) {
			return "The initial diameter of border " + args[0] + " is " + args[1] + " block(s)";
		}
	}
}
