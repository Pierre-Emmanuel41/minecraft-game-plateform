package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class DeleteBorder_BorderDeleted extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteBorder_BorderDeleted() {
		super(EBorderMessageCode.DELETE_BORDER__BORDER_DELETED);
	}

	private static class French extends DeleteBorder_BorderDeleted {
		@Override
		public String getMessage(String... args) {
			return "Le fichier de la bordure " + args[0] + " a été supprimé";
		}
	}

	private static class English extends DeleteBorder_BorderDeleted {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " border's file has been deleted";
		}
	}
}
