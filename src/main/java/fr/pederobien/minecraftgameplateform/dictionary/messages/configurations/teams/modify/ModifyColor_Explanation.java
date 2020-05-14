package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyColor_Explanation extends AbstractNotDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyColor_Explanation(String message) {
		super(ETeamModifyMessageCode.MODIFY_COLOR__EXPLANATION, message);
	}

	private static class French extends ModifyColor_Explanation {
		public French() {
			super("Pour modifier la couleur d'une �quipe");
		}
	}

	private static class English extends ModifyColor_Explanation {
		public English() {
			super("To modify the color of a team");
		}
	}
}
