package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteBorder_DidNotDelete extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public DeleteBorder_DidNotDelete() {
		super(EBorderMessageCode.DELETE_BORDER__DID_NOT_DELETED);
	}

	private static class French extends DeleteBorder_DidNotDelete {
		@Override
		public String getMessage(Object... args) {
			return "La suppresion de la bordure " + args[0] + " n'a pas pu s'effectuer correctement";
		}
	}

	private static class English extends DeleteBorder_DidNotDelete {
		@Override
		public String getMessage(Object... args) {
			return "The deletion of border " + args[0] + " was not successful";
		}
	}
}
