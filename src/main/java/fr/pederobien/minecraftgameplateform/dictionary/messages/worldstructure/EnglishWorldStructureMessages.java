package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishWorldStructureMessages {
	BAD_DIMENSION_FORMAT(CommonDimension_BadDimensionFormat.ENGLISH),

	MISSING_DIMENSION(CommonDimension_MissingDimension.ENGLISH),

	WORLD_DOES_NOT_EXIST(CommonWorld_WorldDoesNotExist.ENGLISH);

	private IMessage source;

	private EnglishWorldStructureMessages(IMessage source) {
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
	public IMessage getSource() {
		return source;
	}
}
