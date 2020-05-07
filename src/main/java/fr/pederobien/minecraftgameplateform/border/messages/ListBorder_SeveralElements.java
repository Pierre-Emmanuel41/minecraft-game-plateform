package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ListBorder_SeveralElements extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ListBorder_SeveralElements() {
		super(EBorderMessageCode.LIST_BORDER__SEVERAL_ELEMENTS);
	}

	private static class French extends ListBorder_SeveralElements {
		@Override
		public String getMessage(String... args) {
			return "Liste des bordures existantes :\n" + args[0];
		}
	}

	private static class English extends ListBorder_SeveralElements {
		@Override
		public String getMessage(String... args) {
			return "List of existing borders :\n" + args[0];
		}
	}
}
