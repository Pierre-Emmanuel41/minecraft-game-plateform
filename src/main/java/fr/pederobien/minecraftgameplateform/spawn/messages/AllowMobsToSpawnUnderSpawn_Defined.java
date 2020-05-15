package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AllowMobsToSpawnUnderSpawn_Defined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AllowMobsToSpawnUnderSpawn_Defined() {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED);
	}

	private static class French extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(Object... args) {
			return "La r�gle allowMobsUnderSpawn est d�finie sur : " + args[0];
		}
	}

	private static class English extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(Object... args) {
			return "The rule allowMobsUnderSpawn is defined as : " + args[1];
		}
	}
}
