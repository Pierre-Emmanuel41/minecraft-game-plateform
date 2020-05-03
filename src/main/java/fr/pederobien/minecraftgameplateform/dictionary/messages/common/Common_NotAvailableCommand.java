package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NotAvailableCommand extends AbstractDynamicMessage {

	public Common_NotAvailableCommand() {
		super(ECommonMessageCode.COMMON_NOT_AVAILABLE_COMMAND);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends Common_NotAvailableCommand {
		@Override
		public String getMessage(String... args) {
			return "La commande \"" + args[0] + "\" n'est pas disponible";
		}
	}

	private static class English extends Common_NotAvailableCommand {
		@Override
		public String getMessage(String... args) {
			return "The command \"" + args[0] + "\" is not available";
		}
	}
}
