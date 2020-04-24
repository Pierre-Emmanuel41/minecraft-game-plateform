package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_TeamDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when adding players to a not existing team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when adding players to a not existing team.
	 */
	public static final IMessage ENGLISH = new English();

	public AddPlayer_TeamDoesNotExist() {
		super(ETeamAddMessageCode.ADD_PLAYER__TEAM_DOES_NOT_EXIST);
	}

	private static class French extends AddPlayer_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible d'ajouter des joueurs à l'équipe \"" + args[0] + "\", elle n'existe pas dans la configuration " + args[1];
		}
	}

	private static class English extends AddPlayer_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot add players to team \"" + args[0] + "\", it does not exist for configuration " + args[1];
		}
	}
}
