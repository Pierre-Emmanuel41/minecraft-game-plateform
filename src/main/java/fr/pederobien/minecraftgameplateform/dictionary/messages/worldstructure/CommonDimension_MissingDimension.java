package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonDimension_MissingDimension extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CommonDimension_MissingDimension(String message) {
		super(EWorldStructureMessageCode.COMMON_DIMENSION__MISSING_DIMENSION, message);
	}

	private static class French extends CommonDimension_MissingDimension {
		public French() {
			super("Impossible de définir les dimensions, il manque la largeur <X> ou la hauteur <Y> ou la profondeur <Z>");
		}
	}

	private static class English extends CommonDimension_MissingDimension {
		public English() {
			super("Cannot set dimensions, width <X>, height <Y> or depth <Z> is missing");
		}
	}
}
