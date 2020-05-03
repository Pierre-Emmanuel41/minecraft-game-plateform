package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_ColorNameIsMissing extends AbstractDynamicMessage {

	public AddTeam_ColorNameIsMissing() {
		super(ETeamAddMessageCode.ADD_TEAM__COLOR_NAME_IS_MISSING);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddTeam_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'équipe \"" + args[0] + "\" à la configuration " + args[1] + ", il manque la couleur";
		}
	}

	private static class English extends AddTeam_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team \"" + args[0] + "\" to the configuration " + args[1] + ", the color is missing";
		}
	}
}
