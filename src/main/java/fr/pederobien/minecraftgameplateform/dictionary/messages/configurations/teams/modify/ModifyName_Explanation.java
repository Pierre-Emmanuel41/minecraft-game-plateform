package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyName_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyName_Explanation(String message) {
		super(ETeamModifyMessageCode.MODIFY_NAME__EXPLANATION, message);
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
