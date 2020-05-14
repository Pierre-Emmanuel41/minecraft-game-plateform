package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum EnglishCommonMessages {
	HELP_EXPLANATION(Common_HelpExplanation.ENGLISH),

	COMMON_BAD_INTEGER_FORMAT5(Common_BadIntegerFormat.ENGLISH),

	COMMON_BAD_DOUBLE_FORMATS(Common_BadDoubleFormat.ENGLISH),

	COMMON_BAD_BOOLEAN_FORMAT(Common_BadBooleanFormat.ENGLISH),

	COMMON_BAD_TIME_FORMAT(Common_BadTimeFormat.ENGLISH),

	COMMON_ARGUMENT_NOT_FOUND(Common_ArgumentNotFound.ENGLISH),

	COMMON_NOT_AVAILABLE_ARGUMENT(Common_NotAvailableArgument.ENGLISH),

	COMMON_NOT_AVAILABLE_COMMAND(Common_NotAvailableCommand.ENGLISH),

	COMMON_NAME_MUST_NOT_START_WITH_DEFAULT(Common_NameMustNotStartWithDefault.ENGLISH),

	COMMON_MISSING_COORDINATES(Common_MissingCoordinates.ENGLISH),

	COMMON_NEW_TAB_COMPLETE(Common_NewTabComplete.ENGLISH),

	COMMON_RENAME_TAB_COMPLETE(Common_RenameTabComplete.ENGLISH),

	COMMON_PLAYER_DOES_NOT_EXIST(Common_PlayerDoesNotExist.ENGLISH),

	WORLD_DOES_NOT_EXIST(Common_WorldDoesNotExist.ENGLISH),

	COMMON_TIME_ON_TAB_COMPLETE(Common_TimeTabComplete.ENGLISH);

	private IMinecraftMessage source;

	private EnglishCommonMessages(IMinecraftMessage source) {
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
	public IMinecraftMessage getSource() {
		return source;
	}
}
