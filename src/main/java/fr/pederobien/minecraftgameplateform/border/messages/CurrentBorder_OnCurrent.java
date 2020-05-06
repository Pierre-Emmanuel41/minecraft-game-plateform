package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CurrentBorder_OnCurrent extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CurrentBorder_OnCurrent() {
		super(EBorderMessageCode.CURRENT_BORDER__ON_CURRENT);
	}

	private static class French extends CurrentBorder_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Caractéristiques de la bordure courante :\n" + args[0];
		}
	}

	private static class English extends CurrentBorder_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Current border's characteristics :\n" + args[0];
		}
	}
}
