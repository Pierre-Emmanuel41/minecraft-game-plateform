package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class CenterSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French to explain what does the command "center" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to explain what does the command "center" do.
	 */
	public static final IMessage ENGLISH = new English();

	public CenterSpawn_Explanation(String message) {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION, message);
	}

	private static class French extends CenterSpawn_Explanation {
		public French() {
			super("Pour définir le centre du spawn");
		}
	}

	private static class English extends CenterSpawn_Explanation {
		public English() {
			super("To set spawn's center");
		}
	}
}
