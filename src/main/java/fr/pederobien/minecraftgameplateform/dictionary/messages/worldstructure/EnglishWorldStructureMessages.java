package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum EnglishWorldStructureMessages {
	BAD_DIMENSION_FORMAT(CommonDimension_BadDimensionFormat.ENGLISH),

	MISSING_DIMENSION(CommonDimension_MissingDimension.ENGLISH);

	private IMinecraftMessage source;

	private EnglishWorldStructureMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishWorldStructureMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
