package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class DimensionSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "dimension" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "dimension" do.
	 */
	public static final IMessage ENGLISH = new English();

	public DimensionSpawn_Explanation(String message) {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION, message);
	}

	private static class French extends DimensionSpawn_Explanation {
		public French() {
			super("Pour définir les dimensions du spawn");
		}
	}

	private static class English extends DimensionSpawn_Explanation {
		public English() {
			super("to set spawn's dimensions");
		}
	}
}
