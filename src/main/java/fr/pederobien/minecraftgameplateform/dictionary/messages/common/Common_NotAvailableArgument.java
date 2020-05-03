package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NotAvailableArgument extends AbstractDynamicMessage {

	public Common_NotAvailableArgument() {
		super(ECommonMessageCode.COMMON_NOT_AVAILABLE_ARGUMENT);
		ECommonMessages.FRENCH.add(new French());
		ECommonMessages.ENGLISH.add(new English());
	}

	private static class French extends Common_NotAvailableArgument {
		@Override
		public String getMessage(String... args) {
			return "L'argument \"" + args[0] + "\" n'est pas disponible pour la commande " + args[1];
		}
	}

	private static class English extends Common_NotAvailableArgument {
		@Override
		public String getMessage(String... args) {
			return "The argument \"" + args[0] + "\" is not available for command " + args[1];
		}
	}
}
