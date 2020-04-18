package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class RandomSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "random" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in French explains what does the command "random" do.
	 */
	public static final IMessage ENGLISH = new English();

	public RandomSpawn_Explanation(String message) {
		super(ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION, message);
	}

	private static class French extends RandomSpawn_Explanation {
		public French() {
			super("Pour charger aléatoirement un spawn dans le monde");
		}
	}

	private static class English extends RandomSpawn_Explanation {
		public English() {
			super("To launch randomly a spawn on the world");
		}
	}
}
