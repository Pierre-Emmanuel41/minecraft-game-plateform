package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CenterBorder_CenterDefined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public CenterBorder_CenterDefined() {
		super(EBorderMessageCode.CENTER_BORDER__CENTER_DEFINED);
	}

	private static class French extends CenterBorder_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "Le centre de la bordure est d�fini en X=" + args[0] + " Z=" + args[1];
		}
	}

	private static class English extends CenterBorder_CenterDefined {
		@Override
		public String getMessage(String... args) {
			return "The border's center is defined in X=" + args[0] + " Z=" + args[1];
		}
	}
}