package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewBorder_BorderCreated extends AbstractDynamicMessage {

	public NewBorder_BorderCreated() {
		super(EBorderMessageCode.NEW_BORDER__BORDER_CREATED);
		EBorderMessages.FRENCH.add(new French());
		EBorderMessages.ENGLISH.add(new English());
	}

	private static class French extends NewBorder_BorderCreated {
		@Override
		public String getMessage(String... args) {
			return "Bordure " + args[0] + " créée";
		}
	}

	private static class English extends NewBorder_BorderCreated {
		@Override
		public String getMessage(String... args) {
			return "Border " + args[0] + " created";
		}
	}
}
