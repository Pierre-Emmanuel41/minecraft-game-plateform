package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class CurrentSpawn_OnCurrent extends AbstractDynamicMessage {
	/**
	 * Message in French to display current spawn's characteristics.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English to display current spawn's characteristics.
	 */
	public static final IMessage ENGLISH = new English();

	public CurrentSpawn_OnCurrent() {
		super(ESpawnMessageCode.CURRENT_SPAWN__ON_CURRENT);
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
