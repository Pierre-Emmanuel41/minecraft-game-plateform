package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_NewNameIsMissing extends AbstractDynamicMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public ModifyName_NewNameIsMissing() {
		super(ETeamModifyMessageCode.MODIFY_NAME__NEW_NAME_IS_MISSING);
	}

	private static class French extends ModifyName_NewNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'équipe " + args[0] + ", il manque le nouveau nom de l'équipe";
		}
	}

	private static class English extends ModifyName_NewNameIsMissing {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team " + args[0] + ", the new team's name is missing";
		}
	}
}
