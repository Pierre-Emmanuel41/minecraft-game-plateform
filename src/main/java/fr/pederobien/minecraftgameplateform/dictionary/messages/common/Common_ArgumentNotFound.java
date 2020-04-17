package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class Common_ArgumentNotFound extends AbstractDynamicMessage {
	/**
	 * Message in French explains the given argument is an undefined argument.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains the given argument is an undefined argument.
	 */
	public static final IMessage ENGLISH = new English();

	public Common_ArgumentNotFound() {
		super(ECommonMessageCode.COMMON_ARGUMENT_NOT_FOUND);
	}

	private static class French extends Common_ArgumentNotFound {
		@Override
		public String getMessage(String... args) {
			return "Argument \"" + args[0] + "\" non défini pour la commande " + args[1];
		}
	}

	private static class English extends Common_ArgumentNotFound {
		@Override
		public String getMessage(String... args) {
			return "Argument \"" + args[0] + "\" undefined for command " + args[1];
		}
	}
}
