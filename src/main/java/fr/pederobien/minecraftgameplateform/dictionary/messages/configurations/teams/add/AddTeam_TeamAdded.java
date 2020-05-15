package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamAdded extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddTeam_TeamAdded() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_ADDED);
	}

	private static class French extends AddTeam_TeamAdded {
		@Override
		public String getMessage(Object... args) {
			return "Equipe " + args[0] + " ajoutée pour la configuration " + args[1];
		}
	}

	private static class English extends AddTeam_TeamAdded {
		@Override
		public String getMessage(Object... args) {
			return "Team " + args[0] + " has been added for configuration " + args[1];
		}
	}
}
