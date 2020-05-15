package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class AddPlayer_OnePlayerAdded extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public AddPlayer_OnePlayerAdded() {
		super(ETeamAddMessageCode.ADD_PLAYER__ONE_PLAYER_ADDED);
	}

	private static class French extends AddPlayer_OnePlayerAdded {
		@Override
		public String getMessage(Object... args) {
			return "Le joueur " + args[0] + " a été ajouté à l'équipe " + args[1];
		}
	}

	private static class English extends AddPlayer_OnePlayerAdded {
		@Override
		public String getMessage(Object... args) {
			return "The player " + args[0] + " has been added to team " + args[1];
		}
	}
}
