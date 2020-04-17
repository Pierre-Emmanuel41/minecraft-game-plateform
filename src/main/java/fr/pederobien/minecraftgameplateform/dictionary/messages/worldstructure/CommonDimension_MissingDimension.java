package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonDimension_MissingDimension extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains the dimensions are missing.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the dimensions are missing.
	 */
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
