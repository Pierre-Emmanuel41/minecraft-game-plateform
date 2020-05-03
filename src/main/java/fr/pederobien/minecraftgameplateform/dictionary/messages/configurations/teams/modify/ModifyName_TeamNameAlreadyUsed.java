package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamNameAlreadyUsed extends AbstractDynamicMessage {

	public ModifyName_TeamNameAlreadyUsed() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_ALREADY_USED);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyName_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'équipe " + args[0] + " en " + args[1] + ", ce nom est déjà utilisé";
		}
	}

	private static class English extends ModifyName_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team " + args[0] + " as " + args[1] + ", this name is already used";
		}
	}
}
