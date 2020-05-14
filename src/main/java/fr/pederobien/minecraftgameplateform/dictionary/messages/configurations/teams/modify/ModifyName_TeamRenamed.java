package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamRenamed extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyName_TeamRenamed() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_RENAMED);
	}

	private static class French extends ModifyName_TeamRenamed {
		@Override
		public String getMessage(String... args) {
			return "L'�quipe " + args[0] + " a �t� renomm�e en " + args[1];
		}
	}

	private static class English extends ModifyName_TeamRenamed {
		@Override
		public String getMessage(String... args) {
			return "The team " + args[0] + " has been renamed as " + args[1];
		}
	}
}
