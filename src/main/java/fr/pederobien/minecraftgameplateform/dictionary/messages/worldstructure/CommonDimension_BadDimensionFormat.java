package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonDimension_BadDimensionFormat extends AbstractMessage {
	/**
	 * Message in French explains the dimensions does not have the right format.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the dimensions does not have the right format.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonDimension_BadDimensionFormat() {
		super(EWorldStructureMessageCode.COMMON_DIMENSION__BAD_DIMENSION_FORMAT);
	}

	private static class French extends CommonDimension_BadDimensionFormat {

		@Override
		public String getMessage(String... args) {
			return "Mauvais format des dimensions, elles doivent être des entiers";
		}
	}

	private static class English extends CommonDimension_BadDimensionFormat {

		@Override
		public String getMessage(String... args) {
			return "Bad dimensions format, they should be integer";
		}
	}

}
