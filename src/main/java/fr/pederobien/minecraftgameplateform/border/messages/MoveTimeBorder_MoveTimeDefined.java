package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class MoveTimeBorder_MoveTimeDefined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public MoveTimeBorder_MoveTimeDefined() {
		super(EBorderMessageCode.MOVE_TIME_BORDER__MOVE_TIME_DEFINED);
	}

	private static class French extends MoveTimeBorder_MoveTimeDefined {
		@Override
		public String getMessage(String... args) {
			return "La bordure " + args[0] + " se déplacera à son diamètre final en " + args[1] + " à la vitesse de " + args[2] + " bloc/s";
		}
	}

	private static class English extends MoveTimeBorder_MoveTimeDefined {
		@Override
		public String getMessage(String... args) {
			return "The border " + args[0] + " will move to its final diameter in " + args[1] + " with speed " + args[2] + " block/s";
		}
	}
}
