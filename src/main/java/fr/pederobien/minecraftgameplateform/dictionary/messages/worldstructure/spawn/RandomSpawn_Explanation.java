package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RandomSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "random" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in French explains what does the command "random" do.
	 */
	public static final IMessage ENGLISH = new English();

	public RandomSpawn_Explanation() {
		super(ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends RandomSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "Pour charger aléatoirement un spawn dans le monde";
		}
	}

	private static class English extends RandomSpawn_Explanation {
		@Override
		public String getMessage(String... args) {
			return "To launch randomly a spawn on the world";
		}
	}
}
