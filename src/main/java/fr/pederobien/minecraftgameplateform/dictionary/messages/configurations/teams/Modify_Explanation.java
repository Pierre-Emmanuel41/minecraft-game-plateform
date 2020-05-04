package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class Modify_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Modify_Explanation(String message) {
		super(ETeamConfigurationMessageCode.MODIFY__EXPLANATION, message);
	}

	private static class French extends Modify_Explanation {
		public French() {
			super("Pour modifier les caractéristiques d'une équipe");
		}
	}

	private static class English extends Modify_Explanation {
		public English() {
			super("To modify team's characteristics");
		}
	}
}
