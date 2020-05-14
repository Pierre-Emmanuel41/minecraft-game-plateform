package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class List_AnyExistingTeam extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public List_AnyExistingTeam() {
		super(ETeamConfigurationMessageCode.LIST__ANY_EXISTING_TEAM);
	}

	private static class French extends List_AnyExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "Il n'existe aucune équipe pour la configuration " + args[0];
		}
	}

	private static class English extends List_AnyExistingTeam {
		@Override
		public String getMessage(String... args) {
			return "There is any team for configuration " + args[0];
		}
	}
}
