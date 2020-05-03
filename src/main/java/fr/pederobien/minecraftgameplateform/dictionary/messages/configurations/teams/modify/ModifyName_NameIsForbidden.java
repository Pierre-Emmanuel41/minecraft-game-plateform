package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_NameIsForbidden extends AbstractDynamicMessage {

	public ModifyName_NameIsForbidden() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_FORBIDDEN);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyName_NameIsForbidden {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'équipe " + args[0] + " en " + args[1] + ", ce nom est interdit pour une équipe";
		}
	}

	private static class English extends ModifyName_NameIsForbidden {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team " + args[0] + " as " + args[1] + ", this name is forbidden for a team";
		}
	}
}
