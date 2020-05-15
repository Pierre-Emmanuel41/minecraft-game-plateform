package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameIsMissing extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddTeam_TeamNameIsMissing() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_IS_MISSING);
	}

	private static class French extends AddTeam_TeamNameIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Impossible d'ajouter une équipe à la configuration " + args[0] + ", il manque le nom de l'équipe";
		}
	}

	private static class English extends AddTeam_TeamNameIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Cannot add a team to the configuration " + args[0] + ", the team's name is missing";
		}
	}
}
