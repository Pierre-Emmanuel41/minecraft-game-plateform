package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AsCurrent_Explanation extends AbstractNotDynamicMessage {
	/**
	 * Message in French explains what does the command "ascurrent" do.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English explains what does the command "ascurrent" do.
	 */
	public static final IMessage ENGLISH = new English();

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
