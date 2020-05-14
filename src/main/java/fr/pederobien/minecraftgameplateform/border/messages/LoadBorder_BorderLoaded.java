package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class LoadBorder_BorderLoaded extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public LoadBorder_BorderLoaded() {
		super(EBorderMessageCode.LOAD_BORDER__BORDER_LOADED);
	}

	private static class French extends LoadBorder_BorderLoaded {
		@Override
		public String getMessage(String... args) {
			return "La bordure " + args[0] + " a été chargée";
		}
	}

	private static class English extends LoadBorder_BorderLoaded {
		@Override
		public String getMessage(String... args) {
			return "The border " + args[0] + " has been loaded";
		}
	}
}
