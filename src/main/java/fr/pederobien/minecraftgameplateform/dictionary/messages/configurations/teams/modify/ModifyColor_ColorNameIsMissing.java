package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorNameIsMissing extends AbstractDynamicMessage {

	public ModifyColor_ColorNameIsMissing() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_NAME_IS_MISSING);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyColor_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier la couleur de l'équipe " + args[0] + ", il manque le nom de la nouvelle couleur";
		}
	}

	private static class English extends ModifyColor_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot modify the color of team " + args[0] + ", the new color's name is missing";
		}
	}
}
