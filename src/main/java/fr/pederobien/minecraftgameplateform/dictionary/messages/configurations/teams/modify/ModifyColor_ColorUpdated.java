package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorUpdated extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyColor_ColorUpdated() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_UPDATED);
	}

	private static class French extends ModifyColor_ColorUpdated {
		@Override
		public String getMessage(String... args) {
			return "La couleur de l'�quipe " + args[0] + " a �t� mise � jour pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyColor_ColorUpdated {
		@Override
		public String getMessage(String... args) {
			return "The color of team " + args[0] + " has been updated for configuration " + args[1];
		}
	}
}
