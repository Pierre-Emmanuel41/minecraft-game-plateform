package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CommonDimension_MissingDimension extends AbstractNotDynamicMessage {

	public CommonDimension_MissingDimension(String message) {
		super(EWorldStructureMessageCode.COMMON_DIMENSION__MISSING_DIMENSION, message);
		EWorldStructureMessages.FRENCH.add(new French());
		EWorldStructureMessages.ENGLISH.add(new English());
	}

	private static class French extends CommonDimension_MissingDimension {
		public French() {
			super("Impossible de d�finir les dimensions, il manque la largeur <X> ou la hauteur <Y> ou la profondeur <Z>");
		}
	}

	private static class English extends CommonDimension_MissingDimension {
		public English() {
			super("Cannot set dimensions, width <X>, height <Y> or depth <Z> is missing");
		}
	}
}
