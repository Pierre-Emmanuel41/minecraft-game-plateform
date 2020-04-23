package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_SeveralPlayersAdded extends AbstractDynamicMessage {
	/**
	 * Message in French when several players have been added to a team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when several players have been added to a team.
	 */
	public static final IMessage ENGLISH = new English();

	public AddPlayer_SeveralPlayersAdded() {
		super(ETeamAddMessageCode.ADD_PLAYER__SEVERAL_PLAYERS_ADDED);
	}

	private static class French extends AddPlayer_SeveralPlayersAdded {
		@Override
		public String getMessage(String... args) {
			return "Les joueurs " + args[0] + " ont été ajoutés à l'équipe " + args[1];
		}
	}

	private static class English extends AddPlayer_SeveralPlayersAdded {
		@Override
		public String getMessage(String... args) {
			return "Players " + args[0] + " have been added to team " + args[1];
		}
	}
}
