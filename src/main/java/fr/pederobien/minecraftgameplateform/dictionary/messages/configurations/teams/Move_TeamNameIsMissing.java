package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class Move_TeamNameIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public Move_TeamNameIsMissing() {
		super(ETeamConfigurationMessageCode.MOVE__TEAM_NAME_IS_MISSING);
	}

	private static class French extends Move_TeamNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de changer l'équipe du joueur " + args[0] + ", il manque le nom de la nouvelle équipe";
		}
	}

	private static class English extends Move_TeamNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot change the team of player " + args[0] + ", the new team's name is missing";
		}
	}
}
