package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_NewNameIsMissing extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyName_NewNameIsMissing() {
		super(ETeamModifyMessageCode.MODIFY_NAME__NEW_NAME_IS_MISSING);
	}

	private static class French extends ModifyName_NewNameIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de renommer l'�quipe " + args[0] + ", il manque le nouveau nom de l'�quipe";
		}
	}

	private static class English extends ModifyName_NewNameIsMissing {
		@Override
		public String getMessage(Object... args) {
			return "Cannot rename team " + args[0] + ", the new team's name is missing";
		}
	}
}
