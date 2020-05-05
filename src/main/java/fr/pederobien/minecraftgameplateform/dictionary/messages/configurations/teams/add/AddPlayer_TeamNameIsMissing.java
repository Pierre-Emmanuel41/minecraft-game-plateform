package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class AddPlayer_TeamNameIsMissing extends AbstractNotDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public AddPlayer_TeamNameIsMissing(String message) {
		super(ETeamAddMessageCode.ADD_PLAYER__TEAM_NAME_IS_MISSING, message);
	}

	private static class French extends AddPlayer_TeamNameIsMissing {
		public French() {
			super("Impossible d'ajouter des joueurs � une �quipe, il manque le nom de l'�quipe");
		}
	}

	private static class English extends AddPlayer_TeamNameIsMissing {
		public English() {
			super("Cannot add players to a team, the team's name is missing");
		}
	}
}
