package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AllowMobsUnderSpawn_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "allowmobunderspawn" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "allowmobunderspawn" do.
	 */
	public static final IMessage ENGLISH = new English();

	public AllowMobsUnderSpawn_Explanation(String message) {
		super(ESpawnMessageCode.ALLOW_MOB_UNDER_SPAWN__EXPLANATION, message);
	}

	private static class French extends AllowMobsUnderSpawn_Explanation {
		public French() {
			super("Pour autoriser ou non le spawn de mob sous le spawn");
		}
	}

	private static class English extends AllowMobsUnderSpawn_Explanation {
		public English() {
			super("To allow or not the mobs's spawn under the spawn");
		}
	}
}
