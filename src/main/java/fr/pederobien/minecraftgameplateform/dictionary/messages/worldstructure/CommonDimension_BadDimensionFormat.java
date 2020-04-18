package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class CommonDimension_BadDimensionFormat extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains the dimensions does not have the right format.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the dimensions does not have the right format.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonDimension_BadDimensionFormat(String message) {
		super(EWorldStructureMessageCode.COMMON_DIMENSION__BAD_DIMENSION_FORMAT, message);
	}

	private static class French extends CommonDimension_BadDimensionFormat {
		public French() {
			super("Mauvais format des dimensions, elles doivent être des entiers");
		}
	}

	private static class English extends CommonDimension_BadDimensionFormat {
		public English() {
			super("Bad dimensions format, they should be integer");
		}
	}
}
