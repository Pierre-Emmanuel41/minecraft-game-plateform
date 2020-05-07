package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ListBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ListBorder_Explanation(String message) {
		super(EBorderMessageCode.LIST_BORDER__EXPLANATION, message);
	}

	private static class French extends ListBorder_Explanation {
		public French() {
			super("Pour afficher le nom des bordures existantes");
		}
	}

	private static class English extends ListBorder_Explanation {
		public English() {
			super("To display existing border's names");
		}
	}
}
