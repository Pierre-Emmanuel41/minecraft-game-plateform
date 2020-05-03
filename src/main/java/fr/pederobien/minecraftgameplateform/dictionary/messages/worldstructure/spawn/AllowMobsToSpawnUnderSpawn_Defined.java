package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AllowMobsToSpawnUnderSpawn_Defined extends AbstractDynamicMessage {

	public AllowMobsToSpawnUnderSpawn_Defined() {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "La r�gle allowMobsUnderSpawn est d�finie sur : " + args[0];
		}
	}

	private static class English extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "The rule allowMobsUnderSpawn is defined as : " + args[1];
		}
	}
}
