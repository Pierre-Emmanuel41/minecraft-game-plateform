package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AllowMobsUnderSpawn_Defined extends AbstractDynamicMessage {
	/**
	 * Message in French when the game rule allowMobsUnderSpawn has been correctly defined.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the game rule allowMobsUnderSpawn has been correctly defined.
	 */
	public static final IMessage ENGLISH = new English();

	public AllowMobsUnderSpawn_Defined() {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED);
	}

	private static class French extends AllowMobsUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "La règle allowMobsUnderSpawn est définie sur : " + args[0];
		}
	}

	private static class English extends AllowMobsUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "The rule allowMobsUnderSpawn is defined as : " + args[1];
		}
	}
}
