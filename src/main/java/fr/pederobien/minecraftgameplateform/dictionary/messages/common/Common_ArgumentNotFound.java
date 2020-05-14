package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Common_ArgumentNotFound extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
