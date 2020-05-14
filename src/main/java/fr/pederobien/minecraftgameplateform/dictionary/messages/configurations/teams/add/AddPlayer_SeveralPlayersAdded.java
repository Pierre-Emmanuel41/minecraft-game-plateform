package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_SeveralPlayersAdded extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

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
