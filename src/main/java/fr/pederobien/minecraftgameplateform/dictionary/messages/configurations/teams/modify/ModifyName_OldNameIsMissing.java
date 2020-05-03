package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyName_OldNameIsMissing extends AbstractNotDynamicMessage {

	public ModifyName_OldNameIsMissing(String message) {
		super(ETeamModifyMessageCode.MODIFY_NAME__OLD_NAME_IS_MISSING, message);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyName_OldNameIsMissing {
		public French() {
			super("Impossible de renommer une équipe, il manque le nom de l'équipe à renommer");
		}
	}

	private static class English extends ModifyName_OldNameIsMissing {
		public English() {
			super("Cannot rename a team, team's name to rename is missing");
		}
	}
}
