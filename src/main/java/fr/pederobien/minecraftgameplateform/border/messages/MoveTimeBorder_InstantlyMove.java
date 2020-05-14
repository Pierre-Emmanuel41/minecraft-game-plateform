package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class MoveTimeBorder_InstantlyMove extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public MoveTimeBorder_InstantlyMove() {
		super(EBorderMessageCode.MOVE_TIME_BORDER__INSTANTLY_MOVE);
	}

	private static class French extends MoveTimeBorder_InstantlyMove {
		@Override
		public String getMessage(String... args) {
			return "La bordure " + args[0] + " se déplacera instantanément à son diamètre final";
		}
	}

	private static class English extends MoveTimeBorder_InstantlyMove {
		@Override
		public String getMessage(String... args) {
			return "The border " + args[0] + " will instantly moves to its final diameter";
		}
	}
}
