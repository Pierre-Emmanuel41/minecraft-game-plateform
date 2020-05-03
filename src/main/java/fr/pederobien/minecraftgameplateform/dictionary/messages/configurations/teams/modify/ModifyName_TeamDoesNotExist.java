package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamDoesNotExist extends AbstractDynamicMessage {

	public ModifyName_TeamDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_DOES_NOT_EXIST);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'équipe\"" + args[0] + "\", elle n'existe pas pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team \"" + args[0] + "\", it does not exists for configuration " + args[1];
		}
	}
}
