package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_OneExistingTeam extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public List_OneExistingTeam() {
		super(ETeamConfigurationMessageCode.LIST__ONE_EXISTING_TEAM);
	}

	private static class French extends List_OneExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "Il y a une équipe enregistrée pour la configuration " + args[0] + ":\n" + args[1];
		}
	}

	private static class English extends List_OneExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "There is one registered team for configuration " + args[0] + " :\n" + args[1];
		}
	}
}
