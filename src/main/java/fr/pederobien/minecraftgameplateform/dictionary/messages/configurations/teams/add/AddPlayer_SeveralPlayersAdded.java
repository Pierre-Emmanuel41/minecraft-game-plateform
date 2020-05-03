package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_SeveralPlayersAdded extends AbstractDynamicMessage {

	public AddPlayer_SeveralPlayersAdded() {
		super(ETeamAddMessageCode.ADD_PLAYER__SEVERAL_PLAYERS_ADDED);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
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
