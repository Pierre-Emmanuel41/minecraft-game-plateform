package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_SeveralExistingTeams extends AbstractDynamicMessage {
	/**
	 * Message in French when there is several existing team for a configuration.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in French when there is several existing team for a configuration.
	 */
	public static final IMessage ENGLISH = new English();

	public List_SeveralExistingTeams() {
		super(ETeamConfigurationMessageCode.LIST__SEVERAL_EXISTING_TEAMS);
	}

	private static class French extends List_SeveralExistingTeams {
		@Override
		public String getMessage(String... args) {
			return "Liste des équipes pour la configuration " + args[0] + " :\n" + args[1];
		}
	}

	private static class English extends List_SeveralExistingTeams {
		@Override
		public String getMessage(String... args) {
			return "List of teams for configuration " + args[0] + " :\n" + args[1];
		}
	}
}
