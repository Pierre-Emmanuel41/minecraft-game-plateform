package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_ColorDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the color's name does not correspond to a colour.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the color's name does not correspond to a colour.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_ColorDoesNotExist() {
		super(ETeamAddMessageCode.ADD_TEAM__COLOR_DOES_NOT_EXIST);
	}

	private static class French extends AddTeam_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter l'�quipe \"" + args[0] + "\" � la configuration " + args[1] + ", \"" + args[2] + "\" n'est pas une couleur";
		}
	}

	private static class English extends AddTeam_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot add team \"" + args[0] + "\" to the configuration " + args[1] + ", \"" + args[2] + "\" is not a colour";
		}
	}
}