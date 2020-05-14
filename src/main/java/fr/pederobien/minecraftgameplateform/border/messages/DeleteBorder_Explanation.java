package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class DeleteBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public DeleteBorder_Explanation(String message) {
		super(EBorderMessageCode.DELETE_BORDER__EXPLANATION, message);
	}

	private static class French extends DeleteBorder_Explanation {
		public French() {
			super("Pour supprimer le fichier d'une bordure");
		}
	}

	private static class English extends DeleteBorder_Explanation {
		public English() {
			super("To delete a border's file");
		}
	}
}
