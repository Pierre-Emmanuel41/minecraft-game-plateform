package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyColor_Explanation extends AbstractNotDynamicMessage {

	public ModifyColor_Explanation(String message) {
		super(ETeamModifyMessageCode.MODIFY_COLOR__EXPLANATION, message);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyColor_Explanation {
		public French() {
			super("Pour modifier la couleur d'une équipe");
		}
	}

	private static class English extends ModifyColor_Explanation {
		public English() {
			super("To modify the color of a team");
		}
	}
}
