package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_TeamNameAlreadyUsed extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddTeam_TeamNameAlreadyUsed() {
		super(ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_ALREADY_USED);
	}

	private static class French extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(Object... args) {
			return "Impossible d'ajouter l'équipe " + args[0] + " to configuration " + args[1] + ", cette équipe existe déjà";
		}
	}

	private static class English extends AddTeam_TeamNameAlreadyUsed {
		@Override
		public String getMessage(Object... args) {
			return "Cannot add team " + args[0] + " to configuration " + args[1] + ", this team already exists";
		}
	}
}
