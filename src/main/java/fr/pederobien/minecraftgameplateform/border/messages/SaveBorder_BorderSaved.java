package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SaveBorder_BorderSaved extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SaveBorder_BorderSaved() {
		super(EBorderMessageCode.SAVE_BORDER__BORDER_SAVED);
	}

	private static class French extends SaveBorder_BorderSaved {
		@Override
		public String getMessage(String... args) {
			return "Bordure " + args[0] + " sauvegard�e";
		}
	}

	private static class English extends SaveBorder_BorderSaved {
		@Override
		public String getMessage(String... args) {
			return "Border " + args[0] + " saved";
		}
	}
}
