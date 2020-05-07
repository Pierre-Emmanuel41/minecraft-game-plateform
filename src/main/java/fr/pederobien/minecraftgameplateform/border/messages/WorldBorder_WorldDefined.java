package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftgameplateform.spawn.messages.WorldSpawn_WorldDefined;

public class WorldBorder_WorldDefined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public WorldBorder_WorldDefined() {
		super(EBorderMessageCode.WORLD_BORDER__WORLD_DEFINED);
	}

	private static class French extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "Le monde de la bordure " + args[0] + " est " + args[1];
		}
	}

	private static class English extends WorldSpawn_WorldDefined {
		@Override
		public String getMessage(String... args) {
			return "The " + args[0] + " border's world is " + args[1];
		}
	}
}
