package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AllowMobsToSpawnUnderSpawn_Defined extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AllowMobsToSpawnUnderSpawn_Defined() {
		super(ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED);
	}

	private static class French extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "La règle allowMobsUnderSpawn est définie sur : " + args[0];
		}
	}

	private static class English extends AllowMobsToSpawnUnderSpawn_Defined {
		@Override
		public String getMessage(String... args) {
			return "The rule allowMobsUnderSpawn is defined as : " + args[1];
		}
	}
}
