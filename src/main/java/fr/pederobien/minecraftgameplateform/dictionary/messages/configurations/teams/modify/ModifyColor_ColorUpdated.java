package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorUpdated extends AbstractDynamicMessage {

	public ModifyColor_ColorUpdated() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_UPDATED);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
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
