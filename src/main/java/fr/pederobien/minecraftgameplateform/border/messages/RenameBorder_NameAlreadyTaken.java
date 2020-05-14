package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameBorder_NameAlreadyTaken extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameBorder_NameAlreadyTaken() {
		super(EBorderMessageCode.RENAME_BORDER__NAME_ALREADY_TAKEN);
	}

	private static class French extends RenameBorder_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer la bordure " + args[0] + " en " + args[1] + ", une bordure du même nom existe déjà";
		}
	}

	private static class English extends RenameBorder_NameAlreadyTaken {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename border " + args[0] + " as " + args[1] + ", a border with the same name already exist";
		}
	}
}
