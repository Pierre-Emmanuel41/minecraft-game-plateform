package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListBorder_SeveralElements extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ListBorder_SeveralElements() {
		super(EBorderMessageCode.LIST_BORDER__SEVERAL_ELEMENTS);
	}

	private static class French extends ListBorder_SeveralElements {
		@Override
		public String getMessage(Object... args) {
			return "Liste des bordures existantes :\n" + args[0];
		}
	}

	private static class English extends ListBorder_SeveralElements {
		@Override
		public String getMessage(Object... args) {
			return "List of existing borders :\n" + args[0];
		}
	}
}
