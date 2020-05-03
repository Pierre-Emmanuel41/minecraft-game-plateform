package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CurrentSpawn_OnCurrent extends AbstractDynamicMessage {

	public CurrentSpawn_OnCurrent() {
		super(ESpawnMessageCode.CURRENT_SPAWN__ON_CURRENT);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends CurrentSpawn_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Caractéristiques du spawn courant :\n" + args[0];
		}
	}

	private static class English extends CurrentSpawn_OnCurrent {
		@Override
		public String getMessage(String... args) {
			return "Current spawn's characteristics :\n" + args[0];
		}
	}
}
