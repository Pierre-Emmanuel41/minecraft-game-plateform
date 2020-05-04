package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class List_Explanation extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public List_Explanation(String message) {
		super(ETeamConfigurationMessageCode.LIST__EXPLANATION, message);
	}

	private static class French extends List_Explanation {
		public French() {
			super("Pour afficher les �quipes d'une configuration");
		}
	}

	private static class English extends List_Explanation {
		public English() {
			super("To display the teams of a configuration");
		}
	}
}
