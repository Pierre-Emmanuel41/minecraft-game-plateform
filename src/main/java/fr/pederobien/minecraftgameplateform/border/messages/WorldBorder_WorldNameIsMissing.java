package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class WorldBorder_WorldNameIsMissing extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public WorldBorder_WorldNameIsMissing(String message) {
		super(EBorderMessageCode.WORLD_BORDER__WORLD_NAME_IS_MISSING, message);
	}

	private static class French extends WorldBorder_WorldNameIsMissing {
		public French() {
			super("Impossible de définir le monde de la bordure, il manque le nom");
		}
	}

	private static class English extends WorldBorder_WorldNameIsMissing {
		public English() {
			super("Cannot set the border's world, the name is missing");
		}
	}
}
