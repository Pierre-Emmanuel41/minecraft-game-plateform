package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchWorldStructureMessages {
	BAD_DIMENSION_FORMAT(CommonDimension_BadDimensionFormat.FRENCH),

	MISSING_DIMENSION(CommonDimension_MissingDimension.FRENCH);

	private IMinecraftMessage source;

	private FrenchWorldStructureMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchWorldStructureMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
