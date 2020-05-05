package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamRenamed extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ModifyName_TeamRenamed() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_RENAMED);
	}

	private static class French extends ModifyName_TeamRenamed {
		@Override
		public String getMessage(String... args) {
			return "L'équipe " + args[0] + " a été renommée en " + args[1];
		}
	}

	private static class English extends ModifyName_TeamRenamed {
		@Override
		public String getMessage(String... args) {
			return "The team " + args[0] + " has been renamed as " + args[1];
		}
	}
}
