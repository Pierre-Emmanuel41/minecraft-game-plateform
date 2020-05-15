package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamDoesNotExist extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyName_TeamDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_DOES_NOT_EXIST);
	}

	private static class French extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de renommer l'équipe\"" + args[0] + "\", elle n'existe pas pour la configuration " + args[1];
		}
	}

	private static class English extends ModifyName_TeamDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Cannot rename team \"" + args[0] + "\", it does not exists for configuration " + args[1];
		}
	}
}
