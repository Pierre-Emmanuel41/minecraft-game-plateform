package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AsCurrent_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AsCurrent_Explanation(String message) {
		super(EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION, message);
	}

	private static class French extends AsCurrent_Explanation {
		public French() {
			super("Pour définir ce style de jeu en tant que style à lancer par la commande startgame");
		}
	}

	private static class English extends AsCurrent_Explanation {
		public English() {
			super("To set this game style as style to run with command startgame");
		}
	}
}
