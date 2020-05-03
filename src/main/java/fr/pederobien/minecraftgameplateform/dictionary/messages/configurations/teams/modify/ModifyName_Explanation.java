package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyName_Explanation extends AbstractNotDynamicMessage {

	public ModifyName_Explanation(String message) {
		super(ETeamModifyMessageCode.MODIFY_NAME__EXPLANATION, message);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyName_Explanation {
		public French() {
			super("Pour renommer une équipe");
		}
	}

	private static class English extends ModifyName_Explanation {
		public English() {
			super("To rename a team");
		}
	}
}
