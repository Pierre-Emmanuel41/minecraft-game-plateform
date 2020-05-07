package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ListBorder_NoElement extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ListBorder_NoElement(String message) {
		super(EBorderMessageCode.LIST_BORDER__NO_ELEMENT, message);
	}

	private static class French extends ListBorder_NoElement {
		public French() {
			super("Il n’existe aucune bordure");
		}
	}

	private static class English extends ListBorder_NoElement {
		public English() {
			super("No existing border");
		}
	}
}
