package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NotAvailableCommand extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_NotAvailableCommand() {
		super(ECommonMessageCode.COMMON_NOT_AVAILABLE_COMMAND);
	}

	private static class French extends Common_NotAvailableCommand {
		@Override
		public String getMessage(Object... args) {
			return "La commande \"" + args[0] + "\" n'est pas disponible";
		}
	}

	private static class English extends Common_NotAvailableCommand {
		@Override
		public String getMessage(Object... args) {
			return "The command \"" + args[0] + "\" is not available";
		}
	}
}
