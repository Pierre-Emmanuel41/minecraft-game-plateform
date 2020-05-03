package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_TeamDoesNotExist extends AbstractDynamicMessage {

	public ModifyColor_TeamDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__TEAM_DOES_NOT_EXIST);
		ETeamModifyMessages.FRENCH.add(new French());
		ETeamModifyMessages.ENGLISH.add(new English());
	}

	private static class French extends ModifyColor_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier la couleur de l'équipe \"" + args[0] + ", elle n'existe pas pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyColor_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot modifier the color of team " + args[0] + ", it does not exist for configuration " + args[1];
		}
	}
}
