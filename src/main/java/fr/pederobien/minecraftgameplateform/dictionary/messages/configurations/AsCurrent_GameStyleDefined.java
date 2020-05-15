package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AsCurrent_GameStyleDefined extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AsCurrent_GameStyleDefined() {
		super(EGameConfigurationMessageCode.AS_CURRENT__GAME_STYLE_DEFINED);
	}

	private static class French extends AsCurrent_GameStyleDefined {
		@Override
		public String getMessage(Object... args) {
			return "Style " + args[0] + " défini en tant que style à lancer avec la commande startgame";
		}
	}

	private static class English extends AsCurrent_GameStyleDefined {
		@Override
		public String getMessage(Object... args) {
			return "Style " + args[0] + " defined as style to run with command startgame";
		}
	}
}
