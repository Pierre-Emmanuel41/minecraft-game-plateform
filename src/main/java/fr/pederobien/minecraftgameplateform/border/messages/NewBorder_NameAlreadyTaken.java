package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewBorder_NameAlreadyTaken extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NewBorder_NameAlreadyTaken() {
		super(EBorderMessageCode.NEW_BORDER__NAME_ALREADY_TAKEN);
	}

	private static class French extends NewBorder_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Une bordure " + args[0] + " existe déjà";
		}
	}

	private static class English extends NewBorder_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "A border " + args[0] + " already exists";
		}
	}
}
