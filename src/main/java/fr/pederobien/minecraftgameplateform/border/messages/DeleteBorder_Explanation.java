package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.spawn.messages.DeleteSpawn_Explanation;

public class DeleteBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteBorder_Explanation(String message) {
		super(EBorderMessageCode.DELETE_BORDER__EXPLANATION, message);
	}

	private static class French extends DeleteSpawn_Explanation {
		public French() {
			super("Pour supprimer le fichier d'une bordure");
		}
	}

	private static class English extends DeleteSpawn_Explanation {
		public English() {
			super("To delete a border's file");
		}
	}
}
