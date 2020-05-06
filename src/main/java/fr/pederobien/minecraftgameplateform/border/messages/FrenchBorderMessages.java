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

	CURRENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.FRENCH);

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
