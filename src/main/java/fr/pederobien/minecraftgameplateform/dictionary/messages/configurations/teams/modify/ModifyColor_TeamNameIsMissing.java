package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyColor_TeamNameIsMissing extends AbstractNotDynamicMessage {

	public ModifyColor_TeamNameIsMissing(String message) {
		super(ETeamModifyMessageCode.MODIFY_COLOR__TEAM_NAME_IS_MISSING, message);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyColor_TeamNameIsMissing {
		public French() {
			super("Impossible de modifier la couleur d'une équipe, il manque le nom de l'équipe");
		}
	}

	private static class English extends ModifyColor_TeamNameIsMissing {
		public English() {
			super("Cannot modify team's color, the team's name is missing");
		}
	}
}
