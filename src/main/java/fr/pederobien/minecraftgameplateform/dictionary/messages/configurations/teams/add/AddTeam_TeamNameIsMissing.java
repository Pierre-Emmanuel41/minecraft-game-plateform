package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AddTeam_TeamNameIsMissing() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_IS_MISSING);
	}

	private static class French extends AddTeam_TeamNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter une �quipe � la configuration " + args[0] + ", il manque le nom de l'�quipe";
		}
	}

	private static class English extends AddTeam_TeamNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot add a team to the configuration " + args[0] + ", the team's name is missing";
		}
	}
}
