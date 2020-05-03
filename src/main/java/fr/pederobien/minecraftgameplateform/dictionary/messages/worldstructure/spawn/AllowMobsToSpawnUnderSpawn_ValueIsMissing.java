package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AllowMobsToSpawnUnderSpawn_ValueIsMissing extends AbstractNotDynamicMessage {

	public AllowMobsToSpawnUnderSpawn_ValueIsMissing(String message) {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__VALUE_IS_MISSING, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends AllowMobsToSpawnUnderSpawn_ValueIsMissing {
		public French() {
			super("Impossible d'autoriser ou non le spawn de mobs sous le spawn, il manque la valeur");
		}
	}

	private static class English extends AllowMobsToSpawnUnderSpawn_ValueIsMissing {
		public English() {
			super("Cannot allow or not the spawn of mobs under the spawn, the value is missing");
		}
	}
}
