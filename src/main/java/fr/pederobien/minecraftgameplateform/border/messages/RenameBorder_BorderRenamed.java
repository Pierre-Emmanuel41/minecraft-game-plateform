package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class RenameBorder_BorderRenamed extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public RenameBorder_BorderRenamed() {
		super(EBorderMessageCode.RENAME_BORDER__BORDER_RENAMED);
	}

	private static class French extends RenameBorder_BorderRenamed {
		@Override
		public String getMessage(String... args) {
			return "Bordure " + args[0] + " renommée en " + args[1];
		}
	}

	private static class English extends RenameBorder_BorderRenamed {
		@Override
		public String getMessage(String... args) {
			return "Border " + args[0] + " renamed as " + args[1];
		}
	}
}
