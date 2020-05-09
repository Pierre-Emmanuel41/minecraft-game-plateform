package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchCommonMessages {
	HELP_EXPLANATION(Common_HelpExplanation.FRENCH),

	COMMON_BAD_INTEGER_FORMAT(Common_BadIntegerFormat.FRENCH),

	COMMON_BAD_DOUBLE_FORMAT(Common_BadDoubleFormat.FRENCH),

	COMMON_BAD_BOOLEAN_FORMAT(Common_BadBooleanFormat.FRENCH),

	COMMON_ARGUMENT_NOT_FOUND(Common_ArgumentNotFound.FRENCH),

	COMMON_NOT_AVAILABLE_ARGUMENT(Common_NotAvailableArgument.FRENCH),

	COMMON_NOT_AVAILABLE_COMMAND(Common_NotAvailableCommand.FRENCH),

	COMMON_NAME_MUST_NOT_START_WITH_DEFAULT(Common_NameMustNotStartWithDefault.FRENCH),

	COMMON_MISSING_COORDINATES(Common_MissingCoordinates.FRENCH),

	COMMON_NEW_TAB_COMPLETE(Common_NewTabComplete.FRENCH),

	COMMON_RENAME_TAB_COMPLETE(Common_RenameTabComplete.FRENCH),

	COMMON_PLAYER_DOES_NOT_EXIST(Common_PlayerDoesNotExist.FRENCH),

	WORLD_DOES_NOT_EXIST(Common_WorldDoesNotExist.FRENCH),

	COMMON_TIME_TAB_COMPLETE(Common_TimeTabComplete.FRENCH);

	private IMessage source;

	private FrenchCommonMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchCommonMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
