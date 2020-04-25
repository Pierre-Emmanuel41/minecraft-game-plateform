package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_ColorNameIsMissing extends AbstractDynamicMessage {
	/**
	 * Message in French when any colour has been furnished to create a team for a configuration.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when any colour has been furnished to create a team for a configuration.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_ColorNameIsMissing() {
		super(ETeamAddMessageCode.ADD_TEAM__COLOR_NAME_IS_MISSING);
	}

	private static class French extends AddTeam_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'�quipe \"" + args[0] + "\" � la configuration " + args[1] + ", il manque la couleur";
		}
	}

	private static class English extends AddTeam_ColorNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team \"" + args[0] + "\" to the configuration " + args[1] + ", the color is missing";
		}
	}
}