package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public class SpawnParentExplanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "spawn" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "spawn" do.
	 */
	public static final IMessage ENGLISH = new English();

	public SpawnParentExplanation(String message) {
		super(ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, message);
	}

	private static class French extends SpawnParentExplanation {
		public French() {
			super("Pour configurer un spawn");
		}
	}

	private static class English extends SpawnParentExplanation {
		public English() {
			super("To configure a spawn");
		}
	}
}
