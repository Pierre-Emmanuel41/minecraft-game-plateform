package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class NewBorder_BorderCreated extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public NewBorder_BorderCreated() {
		super(EBorderMessageCode.NEW_BORDER__BORDER_CREATED);
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
