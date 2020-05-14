package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class SaveBorder_BorderSaved extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public SaveBorder_BorderSaved() {
		super(EBorderMessageCode.SAVE_BORDER__BORDER_SAVED);
	}

	private static class French extends SaveBorder_BorderSaved {
		@Override
		public String getMessage(String... args) {
			return "Bordure " + args[0] + " sauvegardée";
		}
	}

	private static class English extends SaveBorder_BorderSaved {
		@Override
		public String getMessage(String... args) {
			return "Border " + args[0] + " saved";
		}
	}
}
