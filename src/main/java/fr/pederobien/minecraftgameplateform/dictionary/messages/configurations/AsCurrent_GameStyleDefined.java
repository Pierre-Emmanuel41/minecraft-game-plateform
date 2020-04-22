package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AsCurrent_GameStyleDefined extends AbstractDynamicMessage {
	/**
	 * Message in French when the game style has been successfully defined as the style to run with the command startgame
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the game style has been successfully defined as the style to run with the command startgame
	 */
	public static final IMessage ENGLISH = new English();

	public AsCurrent_GameStyleDefined() {
		super(EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED);
	}

	private static class French extends AsCurrent_GameStyleDefined {
		@Override
		public String getMessage(String... args) {
			return "Style " + args[0] + " d�fini en tant que style � lancer avec la commande startgame";
		}
	}

	private static class English extends AsCurrent_GameStyleDefined {
		@Override
		public String getMessage(String... args) {
			return "Style " + args[0] + " defined as style to run with command startgame";
		}
	}
}