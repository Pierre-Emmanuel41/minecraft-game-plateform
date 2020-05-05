package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishCommonMessages {
	HELP_EXPLANATION(CommonHelp_Explanation.ENGLISH),

	COMMON_BAD_INTEGER_FORMAT5(Common_BadIntegerFormat.ENGLISH),

	COMMON_BAD_BOOLEAN_FORMAT(Common_BadBooleanFormat.ENGLISH),

	COMMON_ARGUMENT_NOT_FOUND(Common_ArgumentNotFound.ENGLISH),

	COMMON_NOT_AVAILABLE_ARGUMENT(Common_NotAvailableArgument.ENGLISH),

	COMMON_NOT_AVAILABLE_COMMAND(Common_NotAvailableCommand.ENGLISH),

	COMMON_NAME_MUST_NOT_START_WITH_DEFAULT(Common_NameMustNotStartWithDefault.ENGLISH),

	COMMON_MISSING_COORDINATES(Common_MissingCoordinates.ENGLISH),

	COMMON_NEW_TAB_COMPLETE(CommonNew_TabComplete.ENGLISH),

	COMMON_RENAME_TAB_COMPLETE(CommonRename_TabComplete.ENGLISH),

	COMMON_PLAYER_DOES_NOT_EXIST(Common_PlayerDoesNotExist.ENGLISH),

	WORLD_DOES_NOT_EXIST(CommonWorld_WorldDoesNotExist.ENGLISH);

	private IMessage source;

	private EnglishCommonMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishCommonMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
