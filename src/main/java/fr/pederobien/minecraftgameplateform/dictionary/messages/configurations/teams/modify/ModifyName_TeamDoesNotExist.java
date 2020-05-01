package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the team's name does not correspond to an existing team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the team's name does not correspond to an existing team.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyName_TeamDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_DOES_NOT_EXIST);
	}

	private static class French extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'�quipe\"" + args[0] + "\", elle n'existe pas pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team \"" + args[0] + "\", it does not exists for configuration " + args[1];
		}
	}
}
