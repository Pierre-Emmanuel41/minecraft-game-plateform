package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchBorderMessages {
	BORDER_EXPLANATION(Border_Explanation.FRENCH),

	NEW_BORDER_EXPLANATION(NewBorder_Explanation.FRENCH),

	NEW_BORDER_NAME_IS_MISSING(NewBorder_NameIsMissing.FRENCH),

	NEW_BORDER_NAME_ALREADY_TAKEN(NewBorder_NameAlreadyTaken.FRENCH),

	NEW_BORDER_BORDER_CREATED(NewBorder_BorderCreated.FRENCH),

	CURRENT_BORDER_EXPLANATION(CurrentBorder_Explanation.FRENCH),

	CURRENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.FRENCH),

	LOAD_BORDER_EXPLANATION(LoadBorder_Explanation.FRENCH),

	LOAD_BORDER_NAME_IS_MISSING(LoadBorder_NameIsMissing.FRENCH),

	LOAD_BORDER_BORDER_LOADED(LoadBorder_BorderLoaded.FRENCH),

	DELETE_BORDER_EXPLANATION(DeleteBorder_Explanation.FRENCH),

	DELETE_BORDER_NAME_IS_MISSING(DeleteBorder_NameIsMissing.FRENCH),

	DELETE_BORDER_DID_NOT_DELETE(DeleteBorder_DidNotDelete.FRENCH),

	DELETE_BORDER_BORDER_DELETED(DeleteBorder_BorderDeleted.FRENCH),

	LIST_BORDER_EXPLANATION(ListBorder_Explanation.FRENCH),

	LIST_BORDER_NO_ELEMENT(ListBorder_NoElement.FRENCH),

	LIST_BORDER_ONE_ELEMENT(ListBorder_OneElement.FRENCH),

	LIST_BORDER_SEVERAL_ELEMENTS(ListBorder_SeveralElements.FRENCH),

	RENAME_BORDER_EXPLANATION(RenameBorder_Explanation.FRENCH),

	WORLD_BORDER_EXPLANATION(WorldBorder_Explanation.FRENCH),

	WORLD_BORDER_WORLD_NAME_IS_MISSING(WorldBorder_WorldNameIsMissing.FRENCH),

	WORLD_BORDER_WORLD_DEFINED(WorldBorder_WorldDefined.FRENCH);

	private IMessage source;

	private FrenchBorderMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchBorderMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
