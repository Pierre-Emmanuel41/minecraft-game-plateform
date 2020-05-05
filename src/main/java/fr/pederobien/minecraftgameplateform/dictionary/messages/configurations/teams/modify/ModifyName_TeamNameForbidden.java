package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamNameForbidden extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ModifyName_TeamNameForbidden() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_FORBIDDEN);
	}

	private static class French extends ModifyName_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'équipe " + args[0] + " en " + args[1] + ", ce nom est interdit pour une équipe";
		}
	}

	private static class English extends ModifyName_TeamNameForbidden {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team " + args[0] + " as " + args[1] + ", this name is forbidden for a team";
		}
	}
}
