package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class ModifyColor_TeamNameIsMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when any team's name has been furnished to modify its colour.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when any team's name has been furnished to modify its colour.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyColor_TeamNameIsMissing(String message) {
		super(ETeamModifyMessageCode.MODIFY_COLOR__TEAM_NAME_IS_MISSING, message);
	}

	private static class French extends ModifyColor_TeamNameIsMissing {
		public French() {
			super("Impossible de modifier la couleur d'une équipe, il manque le nom de l'équipe");
		}
	}

	private static class English extends ModifyColor_TeamNameIsMissing {
		public English() {
			super("Cannot modify team's color, the team's name is missing");
		}
	}
}
