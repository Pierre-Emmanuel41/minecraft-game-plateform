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

	CURENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.ENGLISH),

	DELETE_BORDER_EXPLANATION(DeleteBorder_Explanation.ENGLISH),

	DELETE_BORDER_NAME_IS_MISSING(DeleteBorder_NameIsMissing.ENGLISH),

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
