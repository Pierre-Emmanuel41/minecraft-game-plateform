package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListBorder_OneElement extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ListBorder_OneElement() {
		super(EBorderMessageCode.LIST_BORDER__ONE_ELEMENT);
	}

	private static class French extends ListBorder_OneElement {
		@Override
		public String getMessage(Object... args) {
			return "Il existe une bordure : " + args[0];
		}
	}

	private static class English extends ListBorder_OneElement {
		@Override
		public String getMessage(Object... args) {
			return "One existing border : " + args[0];
		}
	}
}
