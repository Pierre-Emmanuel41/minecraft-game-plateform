package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_NotAvailableArgument extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public Common_NotAvailableArgument() {
		super(ECommonMessageCode.COMMON_NOT_AVAILABLE_ARGUMENT);
	}

	private static class French extends Common_NotAvailableArgument {
		@Override
		public String getMessage(Object... args) {
			return "L'argument \"" + args[0] + "\" n'est pas disponible pour la commande " + args[1];
		}
	}

	private static class English extends Common_NotAvailableArgument {
		@Override
		public String getMessage(Object... args) {
			return "The argument \"" + args[0] + "\" is not available for command " + args[1];
		}
	}
}
