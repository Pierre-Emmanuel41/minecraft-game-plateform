package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class InitialBorderDiameter_DiameterIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public InitialBorderDiameter_DiameterIsMissing() {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__DIAMETER_IS_MISSING);
	}

	private static class French extends InitialBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de d�finir le diam�tre initial de la bordure " + args[0] + ", il manque le diam�tre";
		}
	}

	private static class English extends InitialBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot set the initial diameter of border " + args[0] + ", the diameter is missing";
		}
	}
}
