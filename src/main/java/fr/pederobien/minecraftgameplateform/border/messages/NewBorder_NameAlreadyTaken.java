package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewBorder_NameAlreadyTaken extends AbstractDynamicMessage {

	public NewBorder_NameAlreadyTaken() {
		super(EBorderMessageCode.NEW_BORDER__NAME_ALREADY_TAKEN);
		EBorderMessages.FRENCH.add(new French());
		EBorderMessages.ENGLISH.add(new English());
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
