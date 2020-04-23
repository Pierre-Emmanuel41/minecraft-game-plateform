package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddTeam_ColorAlreadyUsed extends AbstractDynamicMessage {
	/**
	 * Message in French when the colour associated to the name is already used by another team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the colour associated to the name is already used by another team.
	 */
	public static final IMessage ENGLISH = new English();

	public AddTeam_ColorAlreadyUsed() {
		super(ETeamAddMessageCode.ADD_TEAM__COLOR_ALREADY_USED);
	}

	private static class French extends AddTeam_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "La couleur " + args[0] + " est déjà utilisée par l'équipe " + args[1];
		}
	}

	private static class English extends AddTeam_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "The color " + args[0] + " is already used by team " + args[1];
		}
	}
}
