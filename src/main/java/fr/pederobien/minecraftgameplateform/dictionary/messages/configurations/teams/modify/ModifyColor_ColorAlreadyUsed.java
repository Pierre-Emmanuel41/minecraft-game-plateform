package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorAlreadyUsed extends AbstractDynamicMessage {

	public ModifyColor_ColorAlreadyUsed() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_ALREADY_USED);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyColor_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier la couleur de l'équipe " + args[0] + ", la couleur " + args[1] + " est déjà utilisée par l'équipe " + args[2];
		}
	}

	private static class English extends ModifyColor_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Cannot modify the color of team " + args[0] + ", the color " + args[1] + " is already used by team " + args[2];
		}
	}
}
