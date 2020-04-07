package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class DimensionSpawn_Explanation extends AbstractMessage {
	/**
	 * Message in French explains what does the command "dimension" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "dimension" do.
	 */
	public static final IMessage ENGLISH = new English();

	public DimensionSpawn_Explanation() {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends DimensionSpawn_Explanation {

		@Override
		public String getMessage(String... args) {
			return "Pour définir les dimensions du spawn";
		}
	}

	private static class English extends DimensionSpawn_Explanation {

		@Override
		public String getMessage(String... args) {
			return "to set the dimensions of the spawn";
		}
	}
}
