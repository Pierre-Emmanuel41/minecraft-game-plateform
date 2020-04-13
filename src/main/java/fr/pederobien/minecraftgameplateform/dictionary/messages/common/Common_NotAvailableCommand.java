package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_NotAvailableCommand extends AbstractMessage {
	/**
	 * Message in French explains the given command is not a available.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the given command is not a available.
	 */
	public static final IMessage ENGLISH = new English();

	public Common_NotAvailableCommand() {
		super(ECommonMessageCode.COMMON_NOT_AVAILABLE_COMMAND);
	}

	private static class French extends Common_NotAvailableCommand {
		@Override
		public String getMessage(String... args) {
			return "La commande " + args[0] + " n'est pas disponible";
		}
	}

	private static class English extends Common_NotAvailableCommand {
		@Override
		public String getMessage(String... args) {
			return "The command " + args[0] + " is not available";
		}
	}
}
