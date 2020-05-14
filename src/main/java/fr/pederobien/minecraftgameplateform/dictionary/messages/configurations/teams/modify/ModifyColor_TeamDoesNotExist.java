package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_TeamDoesNotExist extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyColor_TeamDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__TEAM_DOES_NOT_EXIST);
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
