package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_OnePlayerAdded extends AbstractDynamicMessage {

	public AddPlayer_OnePlayerAdded() {
		super(ETeamAddMessageCode.ADD_PLAYER__ONE_PLAYER_ADDED);
		ETeamAddMessages.FRENCH.add(new French());
		ETeamAddMessages.ENGLISH.add(new English());
	}

	private static class French extends AddPlayer_OnePlayerAdded {
		@Override
		public String getMessage(String... args) {
			return "Le joueur " + args[0] + " a été ajouté à l'équipe " + args[1];
		}
	}

	private static class English extends AddPlayer_OnePlayerAdded {
		@Override
		public String getMessage(String... args) {
			return "The player " + args[0] + " has been added to team " + args[1];
		}
	}
}
