package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyName_OldNameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the team's name to rename is missing.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the team's name to rename is missing.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyName_OldNameIsMissing(String message) {
		super(ETeamModifyMessageCode.MODIFY_NAME__OLD_NAME_IS_MISSING, message);
	}

	private static class French extends ModifyName_OldNameIsMissing {
		public French() {
			super("Impossible de renommer une équipe, il manque le nom de l'équipe à renommer");
		}
	}

	private static class English extends ModifyName_OldNameIsMissing {
		public English() {
			super("Cannot rename a team, team's name to rename is missing");
		}
	}
}
