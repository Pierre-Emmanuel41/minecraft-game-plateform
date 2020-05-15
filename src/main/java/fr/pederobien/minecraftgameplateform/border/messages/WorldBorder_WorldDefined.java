package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class WorldBorder_WorldDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public WorldBorder_WorldDefined() {
		super(EBorderMessageCode.WORLD_BORDER__WORLD_DEFINED);
	}

	private static class French extends WorldBorder_WorldDefined {
		@Override
		public String getMessage(Object... args) {
			return "Le monde de la bordure " + args[0] + " est " + args[1];
		}
	}

	private static class English extends WorldBorder_WorldDefined {
		@Override
		public String getMessage(Object... args) {
			return "The " + args[0] + " border's world is " + args[1];
		}
	}
}
