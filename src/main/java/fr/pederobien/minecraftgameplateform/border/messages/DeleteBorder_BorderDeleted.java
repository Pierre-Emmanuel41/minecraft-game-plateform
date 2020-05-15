package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteBorder_BorderDeleted extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public DeleteBorder_BorderDeleted() {
		super(EBorderMessageCode.DELETE_BORDER__BORDER_DELETED);
	}

	private static class French extends DeleteBorder_BorderDeleted {
		@Override
		public String getMessage(Object... args) {
			return "Le fichier de la bordure " + args[0] + " a été supprimé";
		}
	}

	private static class English extends DeleteBorder_BorderDeleted {
		@Override
		public String getMessage(Object... args) {
			return "The " + args[0] + " border's file has been deleted";
		}
	}
}
