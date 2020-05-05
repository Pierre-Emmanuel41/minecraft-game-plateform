package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishTeamModifyMessages {
	MODIFY_NAME_EXPLANATION(ModifyName_Explanation.ENGLISH),

	MODIFY_NAME_OLD_NAME_IS_MISSING(ModifyName_OldNameIsMissing.ENGLISH),

	MODIFY_NAME_NEW_NAME_IS_MISSING(ModifyName_NewNameIsMissing.ENGLISH),

	MODIFY_NAME_TEAM_DOES_NOT_EXIST(ModifyName_TeamDoesNotExist.ENGLISH),

	MODIFY_NAME_TEAM_NAME_FORBIDDEN(ModifyName_TeamNameForbidden.ENGLISH),

	MODIFY_NAME_TEAM_NAME_ALREADY_USED(ModifyName_TeamNameAlreadyUsed.ENGLISH),

	MODIFY_NAME_TEAM_RENAMED(ModifyName_TeamRenamed.ENGLISH),

	MODIFY_COLOR_EXPLANATION(ModifyColor_Explanation.ENGLISH),

	MODIFY_COLOR_TEAM_NAME_IS_MISSING(ModifyColor_TeamNameIsMissing.ENGLISH),

	MODIFY_COLOR_NAME_IS_MISSING(ModifyColor_ColorNameIsMissing.ENGLISH),

	MODIFY_COLOR_TEAM_DOES_NOT_EXISST(ModifyColor_TeamDoesNotExist.ENGLISH),

	MODIFY_COLOR_COLOR_DOES_NOT_EXIST(ModifyColor_TeamDoesNotExist.ENGLISH),

	MODIFY_COLOR_COLOR_ALREADY_USED(ModifyColor_ColorAlreadyUsed.ENGLISH),

	MODIFY_COLOR_COLOR_UPDATED(ModifyColor_ColorUpdated.ENGLISH);

	private IMessage source;

	private EnglishTeamModifyMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishTeamModifyMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
