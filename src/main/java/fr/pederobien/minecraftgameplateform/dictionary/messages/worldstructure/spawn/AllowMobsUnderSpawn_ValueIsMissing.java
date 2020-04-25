package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AllowMobsUnderSpawn_ValueIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the value is missing to allow the spawn of mobs under the spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the value is missing to allow the spawn of mobs under the spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public AllowMobsUnderSpawn_ValueIsMissing(String message) {
		super(ESpawnMessageCode.ALLOW_MOB_UNDER_SPAWN__VALUE_IS_MISSING, message);
	}

	private static class French extends AllowMobsUnderSpawn_ValueIsMissing {
		public French() {
			super("Impossible d'autoriser ou non le spawn de mobs sous le spawn, il manque la valeur");
		}
	}

	private static class English extends AllowMobsUnderSpawn_ValueIsMissing {
		public English() {
			super("Cannot allow or not the spawn of mobs under the spawn, the value is missing");
		}
	}
}
