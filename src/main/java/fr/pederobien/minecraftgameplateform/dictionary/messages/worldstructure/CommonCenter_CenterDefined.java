package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class CommonCenter_CenterDefined extends AbstractMessage {
	/**
	 * Message in French explains the center has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the center has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public CommonCenter_CenterDefined() {
		super(EWorldStructureMessageCode.COMMON_CENTER__CENTER_DEFINED);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends CommonCenter_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "Centre défini en " + args[0] + " " + args[1] + " " + args[2];
		}
	}

	private static class English extends CommonCenter_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "Center defined in " + args[0] + " " + args[1] + " " + args[2];
		}
	}

}
