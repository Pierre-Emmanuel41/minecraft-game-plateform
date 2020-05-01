package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorUpdated extends AbstractDynamicMessage {
	/**
	 * Message in French when the new team's colour has been updated successfully.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new team's colour has been updated successfully.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyColor_ColorUpdated() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_UPDATED);
	}

	private static class French extends ModifyColor_ColorUpdated {
		@Override
		public String getMessage(String... args) {
			return "La couleur de l'équipe " + args[0] + " a été mise à jour pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyColor_ColorUpdated {
		@Override
		public String getMessage(String... args) {
			return "The color of team " + args[0] + " has been updated for configuration " + args[1];
		}
	}
}
