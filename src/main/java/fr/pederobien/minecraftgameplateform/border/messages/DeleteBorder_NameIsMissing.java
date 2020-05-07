package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.spawn.messages.DeleteSpawn_NameIsMissing;

public class DeleteBorder_NameIsMissing extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public DeleteBorder_NameIsMissing(String message) {
		super(EBorderMessageCode.DELETE_BORDER__NAME_IS_MISSING, message);
	}

	private static class French extends DeleteSpawn_NameIsMissing {
		public French() {
			super("Impossible de supprimer une bordue, il manque le nom");
		}
	}

	private static class English extends DeleteSpawn_NameIsMissing {
		public English() {
			super("Cannot delete a border, the name is missing");
		}
	}
}
