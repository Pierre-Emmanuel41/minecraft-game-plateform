package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyName_TeamNameAlreadyUsed extends AbstractDynamicMessage {
	/**
	 * Message in French when the new team's name is already used by another team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new team's name is already used by another team.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyName_TeamNameAlreadyUsed() {
		super(ETeamModifyMessageCode.MODIFY_NAME__TEAM_NAME_ALREADY_USED);
	}

	private static class French extends ModifyName_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Impossible de renommer l'�quipe " + args[0] + " en " + args[1] + ", ce nom est d�j� utilis�";
		}
	}

	private static class English extends ModifyName_TeamNameAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Cannot rename team " + args[0] + " as " + args[1] + ", this name is already used";
		}
	}
}