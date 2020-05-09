package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SpeedBorder_SpeedDefined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SpeedBorder_SpeedDefined() {
		super(EBorderMessageCode.SPEED_BORDER__SPEED_DEFINED);
	}

	private static class French extends SpeedBorder_SpeedDefined {
		@Override
		public String getMessage(String... args) {
			return "la vitesse de la bordure " + args[0] + " est défini à " + args[1] + " bloc/s, temps de déplacement : " + args[2];
		}
	}

	private static class English extends SpeedBorder_SpeedDefined {
		@Override
		public String getMessage(String... args) {
			return "The speed of border " + args[0] + " is " + args[1] + " block/s, time to move the border :  " + args[2];
		}
	}
}
