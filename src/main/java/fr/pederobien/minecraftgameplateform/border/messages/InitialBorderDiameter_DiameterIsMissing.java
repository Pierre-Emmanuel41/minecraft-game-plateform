package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class InitialBorderDiameter_DiameterIsMissing extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public InitialBorderDiameter_DiameterIsMissing() {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__DIAMETER_IS_MISSING);
	}

	private static class French extends InitialBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de définir le diamètre initial de la bordure " + args[0] + ", il manque le diamètre";
		}
	}

	private static class English extends InitialBorderDiameter_DiameterIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Cannot set the initial diameter of border " + args[0] + ", the diameter is missing";
		}
	}
}
