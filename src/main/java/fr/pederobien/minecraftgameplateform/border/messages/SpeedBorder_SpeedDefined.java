package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SpeedBorder_SpeedDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SpeedBorder_SpeedDefined() {
		super(EBorderMessageCode.SPEED_BORDER__SPEED_DEFINED);
	}

	private static class French extends SpeedBorder_SpeedDefined {
		@Override
		public String getMessage(Object... args) {
			return "la vitesse de la bordure " + args[0] + " est d�fini � " + args[1] + " bloc/s, temps de d�placement : " + args[2];
		}
	}

	private static class English extends SpeedBorder_SpeedDefined {
		@Override
		public String getMessage(Object... args) {
			return "The speed of border " + args[0] + " is " + args[1] + " block/s, time to move the border :  " + args[2];
		}
	}
}
