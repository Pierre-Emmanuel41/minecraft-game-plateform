package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishBorderMessages {
	BORDER_EXPLANATION(Border_Explanation.ENGLISH),

	NEW_BORDER_EXPLANATION(NewBorder_Explanation.ENGLISH),

	NEW_BORDER_NAME_IS_MISSING(NewBorder_NameIsMissing.ENGLISH),

	NEW_BORDER_NAME_ALREADY_TAKEN(NewBorder_NameAlreadyTaken.ENGLISH),

	NEW_BORDER_BORDER_CREATED(NewBorder_BorderCreated.ENGLISH),

	CURRENT_BORDER_EXPLANATION(CurrentBorder_Explanation.ENGLISH),

	CURRENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.ENGLISH),

	LOAD_BORDER_EXPLANATION(LoadBorder_Explanation.ENGLISH),

	LOAD_BORDER_NAME_IS_MISSING(LoadBorder_NameIsMissing.ENGLISH),

	LOAD_BORDER_BORDER_LOADED(LoadBorder_BorderLoaded.ENGLISH),

	DELETE_BORDER_EXPLANATION(DeleteBorder_Explanation.ENGLISH),

	DELETE_BORDER_NAME_IS_MISSING(DeleteBorder_NameIsMissing.ENGLISH),

	DELETE_BORDER_DID_NOT_DELETE(DeleteBorder_DidNotDelete.ENGLISH),

	DELETE_BORDER_BORDER_DELETED(DeleteBorder_BorderDeleted.ENGLISH),

	LIST_BORDER_EXPLANATION(ListBorder_Explanation.ENGLISH),

	LIST_BORDER_NO_ELEMENT(ListBorder_NoElement.ENGLISH),

	LIST_BORDER_ONE_ELEMENT(ListBorder_OneElement.ENGLISH),

	LIST_BORDER_SEVERAL_ELEMENTS(ListBorder_SeveralElements.ENGLISH),

	RENAME_BORDER_EXPLANATION(RenameBorder_Explanation.ENGLISH),

	RENAME_BORDER_NAME_IS_MISSING(RenameBorder_NameIsMissing.ENGLISH),

	RENAME_BORDER_NAME_ALREADY_TAKEN(RenameBorder_NameAlreadyTaken.ENGLISH),

	WORLD_BORDER_EXPLANATION(WorldBorder_Explanation.ENGLISH),

	WORLD_BORDER_WORLD_NAME_IS_MISSING(WorldBorder_WorldNameIsMissing.ENGLISH),

	WORLD_BORDER_WORLD_DEFINED(WorldBorder_WorldDefined.ENGLISH);

	private IMessage source;

	private EnglishBorderMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishBorderMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
