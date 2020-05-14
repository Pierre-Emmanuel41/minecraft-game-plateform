package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class InitialBorderDiameter_NegativeDiameter extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public InitialBorderDiameter_NegativeDiameter() {
		super(EBorderMessageCode.INITIAL_BORDER_DIAMETER__NEGATIVE_DIAMETER);
	}

	public static class French extends InitialBorderDiameter_NegativeDiameter {
		@Override
		public String getMessage(String... args) {
			return "Impossible de définir le diamètre initial de la bordure " + args[0] + ", le diamètre est négatif";
		}
	}

	public static class English extends InitialBorderDiameter_NegativeDiameter {
		@Override
		public String getMessage(String... args) {
			return "Cannot set the initial diameter of border " + args[0] + ", the diameter is negative";
		}
	}
}
