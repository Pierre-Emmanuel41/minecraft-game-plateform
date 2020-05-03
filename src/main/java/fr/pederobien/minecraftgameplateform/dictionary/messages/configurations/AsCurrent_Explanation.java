package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AsCurrent_Explanation extends AbstractNotDynamicMessage {

	public AsCurrent_Explanation(String message) {
		super(EGameConfigurationMessageCode.AS_CURRENT__EXPLANATION, message);
		EGameConfigurationMessages.FRENCH.add(new French());
		EGameConfigurationMessages.ENGLISH.add(new English());
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
