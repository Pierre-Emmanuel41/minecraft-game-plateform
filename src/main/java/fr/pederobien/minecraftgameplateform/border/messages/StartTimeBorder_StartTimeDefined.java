package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class StartTimeBorder_StartTimeDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public StartTimeBorder_StartTimeDefined() {
		super(EBorderMessageCode.START_TIME_BORDER__START_TIME_DEFINED);
	}

	private static class French extends StartTimeBorder_StartTimeDefined {
		@Override
		public String getMessage(String... args) {
			return "La bordure " + args[0] + " se déplacera après " + args[1] + " de jeu";
		}
	}

	private static class English extends StartTimeBorder_StartTimeDefined {
		@Override
		public String getMessage(String... args) {
			return "The border " + args[0] + " will move after " + args[1] + " of play";
		}
	}
}
