package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class WorldBorder_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public WorldBorder_Explanation(String message) {
		super(EBorderMessageCode.WORLD_BORDER__EXPLANATION, message);
	}

	private static class French extends WorldBorder_Explanation {
		public French() {
			super("Pour d�finir le monde dans lequel la bordure s'applique");
		}
	}

	private static class English extends WorldBorder_Explanation {
		public English() {
			super("To define the world in which the border is applied");
		}
	}
}
