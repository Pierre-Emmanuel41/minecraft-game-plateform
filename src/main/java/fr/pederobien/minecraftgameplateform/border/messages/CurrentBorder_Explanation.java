package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class CurrentBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public CurrentBorder_Explanation(String message) {
		super(EBorderMessageCode.CURRENT_BORDER__EXPLANATION, message);
	}

	private static class French extends CurrentBorder_Explanation {
		public French() {
			super("Pour afficher les caractéristiques de la bordure courante");
		}
	}

	private static class English extends CurrentBorder_Explanation {
		public English() {
			super("To display current border's characteristics");
		}
	}
}
