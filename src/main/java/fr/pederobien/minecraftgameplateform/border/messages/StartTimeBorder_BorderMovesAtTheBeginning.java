package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class StartTimeBorder_BorderMovesAtTheBeginning extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public StartTimeBorder_BorderMovesAtTheBeginning() {
		super(EBorderMessageCode.START_TIME_BORDER__BORDER_MOVES_AT_THE_BEGINNING);
	}

	private static class French extends StartTimeBorder_BorderMovesAtTheBeginning {
		@Override
		public String getMessage(Object... args) {
			return "La bordure " + args[0] + " se déplacera dés le début de la partie";
		}
	}

	private static class English extends StartTimeBorder_BorderMovesAtTheBeginning {
		@Override
		public String getMessage(Object... args) {
			return "The border " + args[0] + " will move from the start of the game";
		}
	}
}
