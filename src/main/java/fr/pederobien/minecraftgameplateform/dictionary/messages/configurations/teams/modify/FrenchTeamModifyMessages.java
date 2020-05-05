package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchTeamModifyMessages {
	MODIFY_NAME_EXPLANATION(ModifyName_Explanation.FRENCH),

	MODIFY_NAME_OLD_NAME_IS_MISSING(ModifyName_OldNameIsMissing.FRENCH),

	MODIFY_NAME_NEW_NAME_IS_MISSING(ModifyName_NewNameIsMissing.FRENCH),

	MODIFY_NAME_TEAM_DOES_NOT_EXIST(ModifyName_TeamDoesNotExist.FRENCH),

	MODIFY_NAME_TEAM_NAME_FORBIDDEN(ModifyName_TeamNameForbidden.FRENCH),

	MODIFY_NAME_TEAM_NAME_ALREADY_USED(ModifyName_TeamNameAlreadyUsed.FRENCH),

	MODIFY_NAME_TEAM_RENAMED(ModifyName_TeamRenamed.FRENCH),

	MODIFY_COLOR_EXPLANATION(ModifyColor_Explanation.FRENCH),

	MODIFY_COLOR_TEAM_NAME_IS_MISSING(ModifyColor_TeamNameIsMissing.FRENCH),

	MODIFY_COLOR_NAME_IS_MISSING(ModifyColor_ColorNameIsMissing.FRENCH),

	MODIFY_COLOR_TEAM_DOES_NOT_EXISST(ModifyColor_TeamDoesNotExist.FRENCH),

	MODIFY_COLOR_COLOR_DOES_NOT_EXIST(ModifyColor_TeamDoesNotExist.FRENCH),

	MODIFY_COLOR_COLOR_ALREADY_USED(ModifyColor_ColorAlreadyUsed.FRENCH),

	MODIFY_COLOR_COLOR_UPDATED(ModifyColor_ColorUpdated.FRENCH);

	private IMessage source;

	private FrenchTeamModifyMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchTeamModifyMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
