package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_ColorDoesNotExist extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddTeam_ColorDoesNotExist() {
		super(ETeamAddMessageCode.ADD_TEAM__COLOR_DOES_NOT_EXIST);
	}

	private static class French extends AddTeam_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'équipe \"" + args[0] + "\" à la configuration " + args[1] + ", \"" + args[2] + "\" n'est pas une couleur";
		}
	}

	private static class English extends AddTeam_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team \"" + args[0] + "\" to the configuration " + args[1] + ", \"" + args[2] + "\" is not a colour";
		}
	}
}