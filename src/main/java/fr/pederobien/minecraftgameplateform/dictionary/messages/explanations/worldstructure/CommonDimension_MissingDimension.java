package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonDimension_MissingDimension extends AbstractMessage {
	/**
	 * Message in French explains the dimensions are missing.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the dimensions are missing.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonDimension_MissingDimension() {
		super(EWorldStructureMessageCode.COMMON_DIMENSION__MISSING_DIMENSION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends CommonDimension_MissingDimension {

		@Override
		public String getMessage(String... args) {
			return "Impossible de définir les dimensions, il manque la largeur <X> ou la hauteur <Y> ou la profondeur <Z>";
		}
	}

	private static class English extends CommonDimension_MissingDimension {

		@Override
		public String getMessage(String... args) {
			return "Cannot set dimensions, width <X>, height <Y> or depth <Z> is missing";
		}
	}
}
